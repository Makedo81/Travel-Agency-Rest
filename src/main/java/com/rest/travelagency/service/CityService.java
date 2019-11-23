package com.rest.travelagency.service;

import com.rest.travelagency.dao.City;
import com.rest.travelagency.dao.CityDao;
import com.rest.travelagency.domain.city.CityDto;
import com.rest.travelagency.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private CityMapper cityMapper;

    public List<CityDto> findCities(final String country) {
        List<City> list = cityDao.findAllByCountry(country);
        return cityMapper.mapToCityDtoList(list);
    }
}
