package com.zup.banco.customvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Cep implements ConstraintValidator<CepValidation, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String regex = "^([^a-zA-Z]{5})[-]([^a-zA-Z]{3})$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		
		return matcher.find();
	}
}