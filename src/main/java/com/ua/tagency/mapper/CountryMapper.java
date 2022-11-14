package com.ua.tagency.mapper;

import com.ua.tagency.dto.CountryDto;
import com.ua.tagency.entity.Country;

public interface CountryMapper {
    CountryDto map(Country country);
}
