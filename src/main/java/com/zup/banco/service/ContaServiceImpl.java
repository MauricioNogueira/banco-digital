package com.zup.banco.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.zup.banco.dto.TransferenciaDto;
import com.zup.banco.email.SendEmail;
import com.zup.banco.formvalidation.FormGeraSenha;
import com.zup.banco.formvalidation.FormPrimeiroAcessoConta;
import com.zup.banco.models.Autenticacao;
import com.zup.banco.models.Cliente;
import com.zup.banco.models.Conta;
import com.zup.banco.models.Transferencia;
import com.zup.banco.repository.ClienteRepository;
import com.zup.banco.repository.ContaRepository;
import com.zup.banco.repository.TransferenciaRepository;
import com.zup.banco.response.Response;

@Service
public class ContaServiceImpl implements ContaService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private SendEmail sendEmail;
	
	public Conta criarConta() {
		String agencia = String.valueOf((int) ((Math.random() * (9999 - 1000)) + 1000));
		String numeroConta = String.valueOf((int) ((Math.random() * (99999999 - 10000000)) + 10000000));
		String codigoBanco = "123";
		
		Conta conta = new Conta(agencia, numeroConta, codigoBanco);
		
		return conta;
	}

	@Override
	@Transactional
	public Response primeiroAcesso(FormPrimeiroAcessoConta form) {
		
		try {			
			Cliente cliente = this.clienteRepository.findByEmailAndCpf(form.getEmail(), form.getCpf());
			
			if (cliente.getConta().getAutenticacao() == null) {				
				cliente = this.autenticacaoService.criarToken(cliente);
			} else {
				Autenticacao autenticacao = this.autenticacaoService.gerarToken(cliente.getConta().getAutenticacao());
				cliente.getConta().setAutenticacao(autenticacao);
			}
			
			this.clienteRepository.save(cliente);
			
			if (!cliente.getConta().getAutenticacao().isUseToken()) {
				
				String titulo = "Chave secreta";
				String mensagem = "Token de acesso: "+cliente.getConta().getAutenticacao().getToken();
				
				this.sendEmail.sendNotification(cliente.getEmail(), titulo, mensagem);
			}
			
			return new Response(1, "Enviamos seu token de acesso para o seu email");
			
		} catch (NullPointerException e) {
			return new Response(5, "Falha ao gerar token");
		}
	}

	@Override
	@Transactional
	public Response gerarSenhaDeAcesso(FormGeraSenha form) {
		try {
			Cliente cliente = this.clienteRepository.findByContaAutenticacaoToken(form.getToken());
			if (cliente.getConta().getSenha() != null) {
				return new Response(5, "Sua senha ja foi gerada");
			}
			
			Response response = this.autenticacaoService.verificaToken(cliente);
			cliente.getConta().getAutenticacao().setUseToken(true);
			
			if (response.getCode() == 3 || response.getCode() == 4) {
				
				cliente.getConta().getAutenticacao().setToken(null);
				cliente.getConta().getAutenticacao().setUseToken(false);
				
				this.clienteRepository.save(cliente);
			} else if (form.getSenha().equals(form.getConfirmarSenha()) && response.getCode() == 1) {
				
				String hash = DigestUtils
						.md5Hex(form.getSenha()).toUpperCase();
				cliente.getConta().setSenha(hash);
				
				String titulo = "Senha de acesso";
				String mensagem = "Senha: "+cliente.getConta().getSenha();
				
				this.sendEmail.sendNotification(cliente.getEmail(), titulo, mensagem);
				this.clienteRepository.save(cliente);
			} else {				
				response = new Response(5, "Senha sao diferentes");
			}
			
			
			
			return response;
		} catch (NullPointerException e) {
			return new Response(5, "Cliente não foi encontrado");
		}
	}

	@Async
	@Override
	public void deposito(List<TransferenciaDto> transferencias) {
		List<TransferenciaDto> transferenciaAceita = new ArrayList<TransferenciaDto>();
		
		transferencias.forEach(transferencia -> {
			Transferencia trans = this.transferenciaRepository.findByCodigoUnico(transferencia.getCodigoUnico());
			
			if (trans == null && verificaCampos(transferencia)) {
				transferenciaAceita.add(transferencia);
			}
		});
		System.out.println(transferenciaAceita.size());
		
		System.out.println(transferencias.size());
		if (transferenciaAceita.size() == transferencias.size()) {
			System.out.println("Tudo certo");
		} else {
			System.out.println("Tudo errado");
		}
	}
	
	public boolean verificaCampos(TransferenciaDto transferencia) {
		System.out.println(transferencia.getValorTransferencia());
		if (transferencia.getAgenciaDestino() != null && transferencia.getAgenciaOrigem() != null && transferencia.getBancoOrigem() != null && transferencia.getCodigoUnico() != null && transferencia.getContaOrigem() != null && transferencia.getDataRealizacao() != null && transferencia.getDocumentoIdentificador() != null && transferencia.getValorTransferencia() != 0) {
			System.out.println("True");
			return true;
		}
		System.out.println("false");
		
		return false;
	}
}
