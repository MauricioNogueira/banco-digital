package com.zup.banco.dto;

public class NaoEncontradoDto {
	private String mensagemErro;
	
	public NaoEncontradoDto(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public String getMensagem() {
		return mensagemErro;
	}
}
