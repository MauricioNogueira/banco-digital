package com.zup.banco.config;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zup.banco.dto.ErroFormularioDto;

@RestControllerAdvice
public class ErroValidacaoUniqueHandle {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public List<ErroFormularioDto> handle(DataIntegrityViolationException exception) {
		List<ErroFormularioDto> erro = new ArrayList<>();
		String regex = "\\(";
		String regex2 = "\\)";
		String texto = exception.getMostSpecificCause().getMessage();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(texto);
		
		List<Integer> posicoes = new ArrayList<Integer>();
		
		while(matcher.find()) {
			posicoes.add(matcher.start());
		}
		
		while(matcher2.find()) {
			posicoes.add(matcher2.start());
		}
		String campo = texto.substring(((posicoes.get(0)) + 1), ((posicoes.get(2))));
		String value = texto.substring(((posicoes.get(1)) + 1), ((posicoes.get(3))));
		
		erro.add(new ErroFormularioDto(campo, "CPF já está cadastrado no sistema"));
		
		return erro;
	}
}
