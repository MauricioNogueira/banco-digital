package com.zup.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.banco.formvalidation.FormCliente;
import com.zup.banco.models.Cliente;
import com.zup.banco.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente cadastrar(FormCliente form) {
		Cliente cliente = new Cliente(form);
		
		cliente = this.clienteRepository.save(cliente);
		
		return cliente;
	}
}
