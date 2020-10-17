package com.zup.banco.formvalidation;

import javax.validation.constraints.NotNull;

import com.zup.banco.customvalidation.CepValidation;

public class FormEndereco {
	@NotNull(message = "Campo obrigatório")
	private String cep;
	
	@NotNull(message = "Campo obrigatório")
	private String rua;
	
	@NotNull(message = "Campo obrigatório")
	private String complemento;
	
	@NotNull(message = "Campo obrigatório")
	private String cidade;
	
	@NotNull(message = "Campo obrigatório")
	private String estado;
	
	@CepValidation
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
