package com.zup.banco.service;

import com.zup.banco.models.Cliente;

public class VerificaArquivo extends VerificaDadosCliente {

	public VerificaArquivo(Cliente cliente, String parada) {
		super(cliente, parada);
	}

	@Override
	public boolean check() {
		if (cliente.getArquivo() != null) {
			return true;
		}
		
		return false;
	}

}
