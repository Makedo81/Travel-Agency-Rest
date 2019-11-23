package com.rest.travelagency.mapper;

import com.rest.travelagency.dao.Country;
import com.rest.travelagency.domain.country.CountryDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    public List<CountryDto> mapToCountryDtoList(final List<Country> countryList) {
        return countryList.stream()
                .map(country1 -> new CountryDto(country1.getName()))
                .collect(Collectors.toList());
    }
}
