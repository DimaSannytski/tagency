package com.ua.tagency.mapper;

import com.ua.tagency.dto.PersonEditDto;
import com.ua.tagency.dto.PersonPageDto;
import com.ua.tagency.dto.RegisterDto;
import com.ua.tagency.entity.Person;

public interface PersonMapper {
    Person registerDtoToPerson(RegisterDto dto);
    PersonPageDto map(Person person);
    PersonEditDto mapEdit(Person person);
}
