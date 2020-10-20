package com.zup.banco.service;

import com.zup.banco.models.Autenticacao;
import com.zup.banco.models.Cliente;
import com.zup.banco.models.Conta;
import com.zup.banco.response.Response;

public interface AutenticacaoService {
	public Cliente criarToken(Cliente cliente);
	public Response verificaToken(Cliente cliente);
	public boolean verificaExpiracaoToken(Autenticacao auth);
	public Autenticacao gerarToken(Autenticacao conta);
}
