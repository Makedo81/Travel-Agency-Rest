package com.rest.travelagency.service;

import com.rest.travelagency.dao.Country;
import com.rest.travelagency.dao.CountryDao;
import com.rest.travelagency.domain.country.CountryDto;
import com.rest.travelagency.mapper.CountryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CountryServiceTestSuites {

    @InjectMocks
    private CountryService countryService;
    @Mock
    private CountryDao countryDao;
    @Mock
    private CountryMapper countryMapper;

    @Test
    public void shouldFetchCountriesList() {
        //Given
        Country poland = new Country();
        poland.setName("Poland");
        Country italy = new Country();
        italy.setName("Italy");
        List<Country> countries = new ArrayList<>();
        countries.add(poland);
        countries.add(italy);

        List<CountryDto> countryDtoList = new ArrayList<>();
        countryDtoList.add(new CountryDto("Poland"));
        countryDtoList.add(new CountryDto("Italy"));

        when(countryDao.findAll()).thenReturn(countries);
        when(countryMapper.mapToCountryDtoList(countries)).thenReturn(countryDtoList);

        //When
        List<CountryDto> result = countryService.findCountries();
        //Then
        assertEquals(2, result.size());
    }
}
