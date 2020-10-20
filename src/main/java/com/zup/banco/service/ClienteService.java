package com.zup.banco.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.banco.dto.ClienteDto;
import com.zup.banco.dto.DadosClienteDto;
import com.zup.banco.formvalidation.FormCliente;
import com.zup.banco.formvalidation.FormEndereco;
import com.zup.banco.formvalidation.FormFinalizarCadastro;
import com.zup.banco.models.Cliente;
import com.zup.banco.response.Resposta;

public interface ClienteService {
	public Cliente cadastrar(FormCliente form);
	public ClienteDto findById(Long id);
	public ClienteDto cadastrarEndereco(FormEndereco form, Long id);
	public ResponseEntity<?> uploadImagem(MultipartFile multipartFile, Long id, UriComponentsBuilder uriComponentsBuilder);
	public DadosClienteDto visualizarDados(Long id);
	public Resposta finalizarCadastro(FormFinalizarCadastro form, Long id);
}
