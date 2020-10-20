package com.zup.banco.service;

import com.zup.banco.formvalidation.FormGeraSenha;
import com.zup.banco.formvalidation.FormPrimeiroAcessoConta;
import com.zup.banco.models.Conta;
import com.zup.banco.response.Response;

public interface ContaService {
	public Conta criarConta();
	public Response primeiroAcesso(FormPrimeiroAcessoConta form);
	public Response gerarSenhaDeAcesso(FormGeraSenha form);
}
