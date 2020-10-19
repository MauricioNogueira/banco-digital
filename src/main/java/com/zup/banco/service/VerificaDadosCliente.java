package com.zup.banco.service;

import org.springframework.stereotype.Service;

import com.zup.banco.models.Cliente;

@Service
public abstract class VerificaDadosCliente {
	
	public Cliente cliente;
	public String parada;
	
	public VerificaDadosCliente(Cliente cliente, String parada) {
		this.cliente = cliente;
		this.parada = parada;
	}

	public abstract boolean check();
}
