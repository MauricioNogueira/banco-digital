package com.zup.banco.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Arquivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeFile;
	private String path;
	private String status;
	
	public Arquivo() {}
	
	public Arquivo(String nomeFile, String path) {
		this.nomeFile = nomeFile;
		this.path = path;
	}
	
	@OneToOne(mappedBy = "arquivo")
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFile() {
		return nomeFile;
	}
	
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
