package com.ua.tagency.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class EditHotelDto {
    @NotNull
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotNull
    private Integer countryId;
    private String description;
}
