package com.zup.banco.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.zup.banco.dto.EnderecoDto;
import com.zup.banco.formvalidation.FormEndereco;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String rua;
	private String complemento;
	private String cidade;
	private String estado;
	
	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;
	
	public Endereco() {}
	
	public Endereco(FormEndereco form) {
		this.cep = form.getCep();
		this.rua = form.getRua();
		this.complemento = form.getComplemento();
		this.cidade = form.getCidade();
		this.estado = form.getEstado();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getCep() {
		return cep;
	}
	
	public String getRua() {
		return rua;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
}
