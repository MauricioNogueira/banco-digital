package com.zup.banco.dto;

public class ErroFormularioDto {
	private String nome;
	private String erro;
	
	public ErroFormularioDto(String nome, String erro) {
		this.nome = nome;
		this.erro = erro;
	}

	public String getNome() {
		return nome;
	}

	public String getErro() {
		return erro;
	}
}
