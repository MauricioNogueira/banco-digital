package com.zup.banco.dto;

import com.zup.banco.models.Endereco;

public class EnderecoDto {
	private String cep;
	private String rua;
	private String complemento;
	private String cidade;
	private String estado;
	
	public EnderecoDto(Endereco endereco) {
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.complemento = endereco.getComplemento();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
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
