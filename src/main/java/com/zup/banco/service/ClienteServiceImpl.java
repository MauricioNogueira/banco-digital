package com.zup.banco.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.banco.dto.ClienteDto;
import com.zup.banco.dto.DadosClienteDto;
import com.zup.banco.dto.NaoEncontradoDto;
import com.zup.banco.formvalidation.FormCliente;
import com.zup.banco.formvalidation.FormEndereco;
import com.zup.banco.models.Arquivo;
import com.zup.banco.models.Cliente;
import com.zup.banco.models.Endereco;
import com.zup.banco.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ArquivoService arquivoService;

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

	@Override
	public ResponseEntity<?> uploadImagem(MultipartFile multipartFile, Long id, UriComponentsBuilder uriComponentsBuilder) {
		Optional<Cliente> optional = this.clienteRepository.findById(id);
		Cliente cliente = null;
		ResponseEntity<DadosClienteDto> response = null;
		
		try {
			if (optional.isPresent()) {
				cliente = optional.get();
			}
			
			String pathImagem = this.arquivoService.uploadImagem(multipartFile);
			
			Arquivo arquivo = new Arquivo(multipartFile.getOriginalFilename(), pathImagem);
			cliente.setArquivo(arquivo);
			
			if (pathImagem == null) {
				return ResponseEntity.badRequest().body(new NaoEncontradoDto());
			}
			
			UriComponents uriComponents =
	                uriComponentsBuilder.path("/cliente/{id}/finalizar").buildAndExpand(id);
			
			this.clienteRepository.save(cliente);
			
			response = ResponseEntity.created(uriComponents.toUri()).body(new DadosClienteDto(cliente));
			
		} catch (NullPointerException nullPointerException) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new NaoEncontradoDto());
		}
		
		return response;
	}

	@Override
	public DadosClienteDto visualizarDados(Long id) {
		Optional<Cliente> optional = this.clienteRepository.findById(id);
		
		if (optional.isPresent()) {
			return new DadosClienteDto(optional.get());
		}
		
		return null;
	}
}
