package com.ua.tagency.validator.val;

import com.ua.tagency.dao.PersonDao;
import com.ua.tagency.validator.UniqueEmail;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailVal implements ConstraintValidator<UniqueEmail, String> {

    private final PersonDao personDao;

    @Autowired
    public UniqueEmailVal(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        return personDao.findPersonByEmail(s) == null;
    }
}
