package com.ua.tagency.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateHotelDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotNull
    private Integer countryId;
    private String description;
}
