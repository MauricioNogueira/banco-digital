package com.zup.banco.service;

import org.springframework.web.multipart.MultipartFile;

public interface ArquivoService {
	public String uploadImagem(MultipartFile multipartFile);
}
