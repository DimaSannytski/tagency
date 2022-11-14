package com.ua.tagency.mapper.impl;

import com.ua.tagency.dto.CountryDto;
import com.ua.tagency.entity.Country;
import com.ua.tagency.mapper.CountryMapper;
import org.springframework.stereotype.Component;

@Component
public class CountryMapperImpl implements CountryMapper {
    @Override
    public CountryDto map(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        return countryDto;
    }
}
