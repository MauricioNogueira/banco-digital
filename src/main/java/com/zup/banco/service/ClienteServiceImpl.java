package com.zup.banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zup.banco.dto.ClienteDto;
import com.zup.banco.formvalidation.FormCliente;
import com.zup.banco.formvalidation.FormEndereco;
import com.zup.banco.models.Cliente;
import com.zup.banco.models.Endereco;
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

	@Override
	public ClienteDto findById(Long id) {
		Optional<Cliente> optional = this.clienteRepository.findById(id);
		
		if (optional.isPresent()) {
			return new ClienteDto(optional.get());
		}
		
		return null;
	}

	@Override
	public ClienteDto cadastrarEndereco(FormEndereco form, Long id) {
		Optional<Cliente> optional = this.clienteRepository.findById(id);
		
		Cliente cliente = optional.get();
		
		Endereco endereco = new Endereco(form);
		cliente.setEndereco(endereco);
		
		this.clienteRepository.save(cliente);
		
		return new ClienteDto(cliente);
	}
}
