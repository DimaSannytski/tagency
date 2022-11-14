package com.ua.tagency.service;

import com.ua.tagency.dto.CountryDto;
import com.ua.tagency.entity.Country;

import java.util.List;

public interface CountryService {
    List<CountryDto> getCountries();
}
