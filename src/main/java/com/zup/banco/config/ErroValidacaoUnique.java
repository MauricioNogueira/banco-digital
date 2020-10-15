package com.zup.banco.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroValidacaoUnique {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void handle(DataIntegrityViolationException exception) {
//		Arrays.asList(exception.getMessage().split("([a-z])"))
//	    .forEach(System.out::println);
//		String []texto = exception.getMessage().split("=");
		
//		System.out.println(texto[0]);
		System.out.println(exception.getMostSpecificCause().getMessage());
	}
}
