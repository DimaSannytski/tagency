package com.ua.tagency.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonPageDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
