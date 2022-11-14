package com.ua.tagency.service;

import com.ua.tagency.dto.PersonDetailsDto;
import com.ua.tagency.dto.PersonEditDto;
import com.ua.tagency.dto.PersonPageDto;
import com.ua.tagency.dto.RegisterDto;

import java.security.Principal;
import java.util.List;

public interface PersonService {
    void register(RegisterDto registerDto);
    void deleteById(Integer id);
    void update(PersonEditDto dto);
    PersonPageDto getPersonPage(Integer id);
    List<PersonPageDto> getAllPersons();
    PersonEditDto getEditDto(Integer id);
    boolean needToAuthorise(Principal principal);
    PersonDetailsDto getPersonDetails(Principal principal);
    Integer getPersonIdFromPrincipal(Principal principal);
}
