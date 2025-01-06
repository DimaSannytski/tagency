package com.ua.tagency.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateRoomsDto {

    private Integer hotelId;
    private String prefix;
    private String suffix;
    private String delimiter;
    private Integer startIndex;
    private Integer amountOfRooms;

    public CreateRoomsDto(Integer hotelId) {
        this.hotelId = hotelId;
    }
}
