package com.zup.banco.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zup.banco.models.Autenticacao;
import com.zup.banco.models.Cliente;
import com.zup.banco.response.Response;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {
	
	@Value("${time.token}")
	private int timeToken;

	@Override
	public Cliente criarToken(Cliente cliente) {
		String digitos = String.valueOf((int) ((Math.random() * (999999 - 100000)) + 100000));
		Calendar cal = Calendar.getInstance(); // pega a data e hora atual
		cal.add(Calendar.SECOND, this.timeToken);
		long dataExpiracao = cal.getTimeInMillis();
		
		Autenticacao auth = new Autenticacao();
		auth.setToken(digitos);
		auth.setDataExpiracao(dataExpiracao);
		cliente.getConta().setAutenticacao(auth);
		return cliente;
	}

	@Override
	public Response verificaToken(Cliente cliente) {
		if (cliente.getConta().getAutenticacao().isUseToken()) {
			return new Response(3, "Token já foi usado");
			
		} else if (verificaExpiracaoToken(cliente.getConta().getAutenticacao())) {
			return new Response(1, "Sua senha de acesso foi gerada");
		}
		
		return new Response(4, "Token foi expirado");
	}

	@Override
	public boolean verificaExpiracaoToken(Autenticacao auth) {
		Calendar dataAtual = Calendar.getInstance();
		Calendar dataToken = Calendar.getInstance();
		
		dataToken.setTimeInMillis(auth.getDataExpiracao());
		System.out.println((dataToken.getTimeInMillis() - dataAtual.getTimeInMillis()) > 0);
		
		if ((dataToken.getTimeInMillis() - dataAtual.getTimeInMillis()) > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public Autenticacao gerarToken(Autenticacao autenticacao) {
		String digitos = String.valueOf((int) ((Math.random() * (999999 - 100000)) + 100000));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 60);
		long dataExpiracao = cal.getTimeInMillis();
		
		autenticacao.setToken(digitos);
		autenticacao.setUseToken(false);
		autenticacao.setDataExpiracao(dataExpiracao);
		
		return autenticacao;
	}

}
