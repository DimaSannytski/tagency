package com.ua.tagency.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class HotelPageDto {
    private Integer id;
    private String name;
    private String address;
    private String countryName;
    private List<RoomDto> rooms;
    private String description;
}
