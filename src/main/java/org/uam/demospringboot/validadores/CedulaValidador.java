package org.uam.demospringboot.validadores;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.uam.demospringboot.anotacion.CedulaValida;

public class CedulaValidador implements ConstraintValidator<CedulaValida,String> {
    @Override
    public boolean isValid(String s
            , ConstraintValidatorContext constraintValidatorContext) {
        return s!=null && s.matches("\\d{3}\\d{6}\\d{4}[A-Z]");
    }
}
