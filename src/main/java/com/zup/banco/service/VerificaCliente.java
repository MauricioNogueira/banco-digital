package com.zup.banco.service;

import com.zup.banco.models.Cliente;

public class VerificaCliente extends VerificaDadosCliente {
	
	public VerificaCliente(Cliente cliente, String parada) {
		super(cliente, parada);
	}

	@Override
	public boolean check() {
		if (cliente != null) {
			VerificaDadosCliente verificaEndereco = new VerificaEndereco(this.cliente, this.parada);
			
			if (this.parada.equals("endereco")) {
				return true;
			}
			
			return verificaEndereco.check();
		}
		
		return false;
	}

}
