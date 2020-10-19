package com.zup.banco.dto;

public class NaoEncontradoDto {
	private String mensagemErro;
	
	public NaoEncontradoDto() {
		this.mensagemErro = "Dados incompletos para o cadastro";
	}

	public String getMensagem() {
		return mensagemErro;
	}
}
