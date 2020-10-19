package com.zup.banco.service;

import org.springframework.web.multipart.MultipartFile;

import com.zup.banco.models.Cliente;

public interface ArquivoService {
	public String uploadImagem(MultipartFile multipartFile);
}
