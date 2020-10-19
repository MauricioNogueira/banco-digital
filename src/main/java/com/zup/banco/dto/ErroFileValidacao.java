package com.zup.banco.dto;

public class ErroFileValidacao {
	private String campo;
	private String mensagem;
	
	public ErroFileValidacao(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
}
