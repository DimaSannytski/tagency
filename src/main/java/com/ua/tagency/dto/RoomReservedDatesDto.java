package com.ua.tagency.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class RoomReservedDatesDto {
    private Date startDate;
    private Date endDate;
    private String startDateStr;
    private String endDateStr;
}
