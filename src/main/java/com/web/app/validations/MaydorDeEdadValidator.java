package com.web.app.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaydorDeEdadValidator implements ConstraintValidator<MayorDeEdad, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		return value  != null && value > 17;
	
	}
}
