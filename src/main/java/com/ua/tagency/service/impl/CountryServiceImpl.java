package com.ua.tagency.service.impl;

import com.ua.tagency.dao.CountryDao;
import com.ua.tagency.dto.CountryDto;
import com.ua.tagency.mapper.CountryMapper;
import com.ua.tagency.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;
    private final CountryMapper mapper;

    public CountryServiceImpl(CountryDao countryDao, CountryMapper mapper) {
        this.countryDao = countryDao;
        this.mapper = mapper;
    }

    @Override
    public List<CountryDto> getCountries() {
        return countryDao.findAll().stream().map(mapper::map).collect(Collectors.toList());
    }
}
