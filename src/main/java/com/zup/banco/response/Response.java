package com.zup.banco.response;

public class Response {
	private int code;
	private String mensagem;
	
	public Response(int code, String mensagem) {
		this.code = code;
		this.mensagem = mensagem;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
