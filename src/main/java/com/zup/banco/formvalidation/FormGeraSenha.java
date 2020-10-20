package com.zup.banco.formvalidation;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class FormGeraSenha {
	private String token;
	
	@Length(min = 8, max = 8, message = "Senha tem que ser de 8 dígitos")
	@NotBlank(message = "Obrigatório")
	private String senha;
	
	@NotBlank(message = "Obrigatório")
	private String confirmarSenha;
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
}
