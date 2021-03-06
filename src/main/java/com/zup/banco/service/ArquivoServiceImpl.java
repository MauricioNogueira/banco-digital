package com.zup.banco.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zup.banco.models.Cliente;

@Service
public class ArquivoServiceImpl implements ArquivoService {

	@Override
	public String uploadImagem(MultipartFile multipartFile) {
		String pathImagem = null;
		try {
			if (!multipartFile.isEmpty()) {				
				pathImagem = multipartFile.getName() + "/"+multipartFile.getOriginalFilename();
				byte[] data = multipartFile.getBytes();
				Path path = Paths.get(pathImagem);
				Files.write(path, data);
			}
		} catch (IOException e) {
			return null;
		}
		
		return pathImagem;
	}
}
