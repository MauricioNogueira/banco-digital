package com.zup.banco.service;

import java.util.List;

import com.zup.banco.dto.TransferenciaDto;
import com.zup.banco.formvalidation.FormGeraSenha;
import com.zup.banco.formvalidation.FormPrimeiroAcessoConta;
import com.zup.banco.models.Conta;
import com.zup.banco.response.Response;

public interface ContaService {
	public Conta criarConta();
	public Response primeiroAcesso(FormPrimeiroAcessoConta form);
	public Response gerarSenhaDeAcesso(FormGeraSenha form);
	public void deposito(List<TransferenciaDto> transferencias);
}
