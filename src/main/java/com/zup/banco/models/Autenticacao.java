package com.zup.banco.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autenticacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String token;
	private long dataExpiracao;
	private boolean useToken = false;
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public long getDataExpiracao() {
		return dataExpiracao;
	}
	
	public void setDataExpiracao(long dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public Long getId() {
		return id;
	}

	public boolean isUseToken() {
		return useToken;
	}

	public void setUseToken(boolean useToken) {
		this.useToken = useToken;
	}
}