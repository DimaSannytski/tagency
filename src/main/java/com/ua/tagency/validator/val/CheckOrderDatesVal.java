package com.ua.tagency.validator.val;

import com.ua.tagency.dao.OrderDao;
import com.ua.tagency.dto.CreateOrderDto;
import com.ua.tagency.validator.CheckOrderDates;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckOrderDatesVal implements ConstraintValidator<CheckOrderDates, CreateOrderDto> {

    private final OrderDao orderDao;

    public CheckOrderDatesVal(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void initialize(CheckOrderDates constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CreateOrderDto dto, ConstraintValidatorContext constraintValidatorContext) {
        return orderDao.invalidDates(dto.getStartDate(), dto.getEndDate());
    }
}
