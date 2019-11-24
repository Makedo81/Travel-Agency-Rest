package com.rest.travelagency.service;

import com.rest.travelagency.dao.City;
import com.rest.travelagency.dao.CityDao;
import com.rest.travelagency.dao.Country;
import com.rest.travelagency.domain.city.CityDto;
import com.rest.travelagency.mapper.CityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CityServiceTestSuites {

    @InjectMocks
    private CityService cityService;
    @Mock
    private CityDao cityDao;
    @Mock
    private CityMapper cityMapper;

    @Test
    public void shouldFetchCitiesList() {
        //Given
        City manchester = new City();
        manchester.setName("Manchester");

        City london = new City();
        london.setName("London");

        List<City> cities = new ArrayList<>();
        cities.add(london);
        cities.add(manchester);

        List<CityDto> citiesDto = new ArrayList<>();
        citiesDto.add(new CityDto("London"));
        citiesDto.add(new CityDto("Manchester"));

        when(cityDao.findAllByCountry(anyString())).thenReturn(cities);
        when(cityMapper.mapToCityDtoList(cities)).thenReturn(citiesDto);

        //When
        List<CityDto> result = cityService.findCities(london.getName());

        //Then
        assertEquals(2, result.size());
    }
}