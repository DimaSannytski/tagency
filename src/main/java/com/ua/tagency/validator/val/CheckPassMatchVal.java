package com.ua.tagency.validator.val;

import com.ua.tagency.dto.RegisterDto;
import com.ua.tagency.validator.CheckPassMatch;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CheckPassMatchVal implements ConstraintValidator<CheckPassMatch, RegisterDto> {
    @Override
    public void initialize(CheckPassMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegisterDto registerDto, ConstraintValidatorContext constraintValidatorContext) {
        return registerDto.getPassword().equals(registerDto.getPasswordConfirmation());
    }
}
