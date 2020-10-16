package com.zup.banco.service;

import com.zup.banco.dto.ClienteDto;
import com.zup.banco.formvalidation.FormCliente;
import com.zup.banco.models.Cliente;

public interface ClienteService {
	public Cliente cadastrar(FormCliente form);
	public ClienteDto findById(Long id);
}
