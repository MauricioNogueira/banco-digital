package com.zup.banco.dto;

import com.zup.banco.models.Arquivo;

public class ArquivoDto {
	private String nomeFile;
	private String path;
	private String status;
	
	public ArquivoDto(Arquivo arquivo) {
		this.nomeFile = arquivo.getNomeFile();
		this.path = arquivo.getPath();
		this.status = arquivo.getStatus();
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public String getPath() {
		return path;
	}

	public String getStatus() {
		return status;
	}
}
