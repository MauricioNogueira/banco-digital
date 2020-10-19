package com.zup.banco.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zup.banco.models.Cliente;

public class DadosClienteDto {
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String dataNascimento;
	private EnderecoDto endereco;
	private ArquivoDto arquivo;
	
	public DadosClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		this.dataNascimento = simpleDate.format(cliente.getDataNascimento());
		
		this.endereco = new EnderecoDto(cliente.getEndereco());
		this.arquivo = new ArquivoDto(cliente.getArquivo());
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public EnderecoDto getEndereco() {
		return endereco;
	}

	public ArquivoDto getArquivo() {
		return arquivo;
	}
}
