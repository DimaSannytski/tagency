package com.ua.tagency.validator;

import com.ua.tagency.validator.val.UniqueEmailVal;
import javax.validation.Constraint;
import javax.validation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailVal.class)
public @interface UniqueEmail {
    String message() default "Mail already exist";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
