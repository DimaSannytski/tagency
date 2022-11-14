package com.ua.tagency.validator;

import com.ua.tagency.validator.val.CheckOrderDatesVal;
import com.ua.tagency.validator.val.CheckPassMatchVal;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckOrderDatesVal.class)
public @interface CheckOrderDates {
    String message() default "Invalid dates";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
