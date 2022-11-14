package com.ua.tagency.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseRoomDto {
    private Integer id;
    private String name;
    private Integer hotelId;
}
