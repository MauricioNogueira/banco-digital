package com.zup.banco.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.banco.dto.ClienteDto;
import com.zup.banco.dto.NaoEncontradoDto;
import com.zup.banco.formvalidation.FormCliente;
import com.zup.banco.models.Cliente;
import com.zup.banco.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@Valid @RequestBody FormCliente form, UriComponentsBuilder uriComponentsBuilder) {
		Cliente cliente = this.clienteService.cadastrar(form);
		
		UriComponents uriComponents =
                uriComponentsBuilder.path("/cliente/{id}/endereco").buildAndExpand(cliente.getId());
		
		return ResponseEntity.created(uriComponents.toUri()).body(new ClienteDto(cliente));
	}
	
	@GetMapping("/{id}/endereco")
	public ResponseEntity<?> endereco(@PathVariable Long id) {
		ClienteDto clienteDto = this.clienteService.findById(id);
		
		if (clienteDto != null) {
			return ResponseEntity.ok(clienteDto);
		}
		
		return ResponseEntity.badRequest().body(new NaoEncontradoDto("Dados incompletos para o cadastro"));
	}
	
	@PostMapping("/{id}/endereco")
	public void cadastrarEndereco() {
		
	}
}
