package com.zup.banco.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.zup.banco.dto.ErroFormularioDto;

@RestControllerAdvice
public class ErroValidacaoHandle {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDto> handle(MethodArgumentNotValidException exception) {
		List<ErroFormularioDto> dtoForm = new ArrayList<>();
		
		List<FieldError> camposErros = exception.getBindingResult().getFieldErrors();
		
		camposErros.forEach(e -> {
			ErroFormularioDto erro = new ErroFormularioDto(e.getField(), e.getDefaultMessage());
			dtoForm.add(erro);
		});
		
		return dtoForm;
	}
}
