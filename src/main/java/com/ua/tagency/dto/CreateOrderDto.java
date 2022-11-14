package com.ua.tagency.dto;

import com.ua.tagency.utils.Constants;
import com.ua.tagency.validator.CheckOrderDates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderDto {
    @DateTimeFormat(pattern = Constants.DATE_PATTERN)
    private Date startDate;
    @DateTimeFormat(pattern = Constants.DATE_PATTERN)
    private Date endDate;
    private Integer roomId;
    private Integer personId;

    public CreateOrderDto(Integer roomId, Integer personId) {
        this.roomId = roomId;
        this.personId = personId;
    }
}
