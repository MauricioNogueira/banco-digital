package com.zup.banco.service;

import org.springframework.stereotype.Service;

import com.zup.banco.models.Conta;

@Service
public class BancoServiceImpl implements BancoService {
	
	public Conta criarConta() {
		String agencia = String.valueOf((int) ((Math.random() * (9999 - 1000)) + 1000));
		String numeroConta = String.valueOf((int) ((Math.random() * (99999999 - 10000000)) + 10000000));
		String codigoBanco = "123";
		
		Conta conta = new Conta(agencia, numeroConta, codigoBanco);
		
		return conta;
	}
}
