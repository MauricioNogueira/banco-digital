package com.zup.banco.service;

import com.zup.banco.models.Cliente;

public class VerificaEndereco extends VerificaDadosCliente{

	public VerificaEndereco(Cliente cliente, String parada) {
		super(cliente, parada);
	}

	@Override
	public boolean check() {
		if (cliente.getEndereco() != null) {
			VerificaDadosCliente verificaArquivo = new VerificaArquivo(this.cliente, this.parada);
			
			if (this.parada.equals("arquivo")) {
				return true;
			}
			
			return verificaArquivo.check();
		}
		
		return false;
	}

}
