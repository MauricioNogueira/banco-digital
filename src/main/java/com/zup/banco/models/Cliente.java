package com.zup.banco.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.zup.banco.formvalidation.FormCliente;


@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String sobrenome;
	
	private String email;
	private Date dataNascimento;
	
	@Column(unique=true)
	private String cpf;
	
	public Cliente() {}
	
	public Cliente(FormCliente form) {
		this.nome = form.getNome();
		this.sobrenome = form.getSobrenome();
		this.email = form.getEmail();
		this.dataNascimento = form.getDataNascimento();
		this.cpf = form.getCpf();
	}
	
	public Long getId() {
		return id;
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
}