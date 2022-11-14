package com.ua.tagency.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelDto {
    private Integer id;
    private String name;
    private String address;
    private String countryName;
    private String description;
}
