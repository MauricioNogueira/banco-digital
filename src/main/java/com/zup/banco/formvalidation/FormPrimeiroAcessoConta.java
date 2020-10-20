package com.zup.banco.formvalidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FormPrimeiroAcessoConta {
	
	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo não pode ser nulo")
	private String email;
	
	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo não pode ser nulo")
	private String cpf;
	
	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
