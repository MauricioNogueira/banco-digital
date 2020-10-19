package com.zup.banco.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.banco.dto.ClienteDto;
import com.zup.banco.dto.DadosClienteDto;
import com.zup.banco.dto.ErroFileValidacao;
import com.zup.banco.dto.NaoEncontradoDto;
import com.zup.banco.formvalidation.FormCliente;
import com.zup.banco.formvalidation.FormEndereco;
import com.zup.banco.models.Cliente;
import com.zup.banco.service.ClienteService;
import com.zup.banco.service.S3Service;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private S3Service s3Service;

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
		
		return ResponseEntity.badRequest().body(new NaoEncontradoDto());
	}
	
	@PostMapping("/{id}/endereco")
	public ResponseEntity<ClienteDto> cadastrarEndereco(@Valid @RequestBody FormEndereco form, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder) {
		ClienteDto clienteDto = this.clienteService.cadastrarEndereco(form, id);
		
		UriComponents uriComponents =
                uriComponentsBuilder.path("/cliente/{id}/anexo").buildAndExpand(id);
		
		return ResponseEntity.created(uriComponents.toUri()).body(clienteDto);
		
	}
	
	@PostMapping(value = "/{id}/anexo",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> anexo(@RequestParam(required = true, value="arquivo") MultipartFile file, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder) {
		
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body(new ErroFileValidacao("arquivo", "Campo obrigatorio"));
		}
		
		return this.clienteService.uploadImagem(file, id, uriComponentsBuilder);
	}
	
	@GetMapping("/{id}/visualizar")
	public ResponseEntity<DadosClienteDto> verificarDados(@PathVariable Long id) {
		DadosClienteDto dadosClienteDto = this.clienteService.visualizarDados(id);
		
		if (dadosClienteDto == null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}
		
		return ResponseEntity.ok(dadosClienteDto);
	}
}
