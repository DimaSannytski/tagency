package com.ua.tagency.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OrderPageDto {
    private Integer id;
    private String creatorName;
    private Date startDate;
    private Date endDate;
    private Integer roomId;
    private Integer creatorId;
    private String roomName;
    private String hotelName;
}
