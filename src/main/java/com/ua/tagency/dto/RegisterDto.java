package com.ua.tagency.dto;

import com.ua.tagency.validator.CheckPassMatch;
import com.ua.tagency.validator.UniqueEmail;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@CheckPassMatch
public class RegisterDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Min(value = 6)
    private String password;
    @Min(value = 6)
    private String passwordConfirmation;
    @UniqueEmail
    @NotEmpty
    private String email;
}
