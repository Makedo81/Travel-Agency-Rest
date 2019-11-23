package com.rest.travelagency.service;

import com.rest.travelagency.dao.Country;
import com.rest.travelagency.dao.CountryDao;
import com.rest.travelagency.domain.country.CountryDto;
import com.rest.travelagency.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;
    @Autowired
    private CountryMapper countryMapper;

    public List<CountryDto> findCountries() {
        List<Country> countries = countryDao.findAll();
        return countryMapper.mapToCountryDtoList(countries);
    }
}
