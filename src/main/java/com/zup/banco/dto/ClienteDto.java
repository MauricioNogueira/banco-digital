package com.zup.banco.dto;

import java.util.Date;

import com.zup.banco.models.Cliente;
import com.zup.banco.models.Endereco;

public class ClienteDto {
	private String nome;
	private String sobrenome;
	private String email;
	private Date dataNascimento;
	private String cpf;
	private Endereco endereco;
	
	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.email = cliente.getEmail();
		this.dataNascimento = cliente.getDataNascimento();
		this.cpf = cliente.getCpf();
		this.endereco = cliente.getEndereco();
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
}
