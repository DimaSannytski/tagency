package com.ua.tagency.mapper.impl;

import com.ua.tagency.dto.PersonEditDto;
import com.ua.tagency.dto.PersonPageDto;
import com.ua.tagency.dto.RegisterDto;
import com.ua.tagency.entity.Person;
import com.ua.tagency.mapper.PersonMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper {
    @Override
    public Person registerDtoToPerson(RegisterDto dto) {
        Person person = new Person();
        person.setEmail(dto.getEmail());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setIsEnabled(true);
        person.setPassword(dto.getPassword());
        return person;
    }

    @Override
    public PersonPageDto map(Person person) {
        PersonPageDto dto = new PersonPageDto();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        return dto;
    }

    @Override
    public PersonEditDto mapEdit(Person person) {
        PersonEditDto dto = new PersonEditDto();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        return dto;
    }

}
