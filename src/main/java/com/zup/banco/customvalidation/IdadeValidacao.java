package com.zup.banco.customvalidation;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdadeValidacao implements ConstraintValidator<IdadeValidation, Date> {

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		GregorianCalendar hoje = new GregorianCalendar();
		GregorianCalendar nascimento = new GregorianCalendar();
		
		nascimento.setTime(value);
		
		int anoHoje = hoje.get(Calendar.YEAR);
		int anoNascimento = nascimento.get(Calendar.YEAR);
		
		return (anoHoje - anoNascimento) >= 18;
	}

}
