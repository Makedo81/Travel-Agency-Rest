package com.rest.travelagency.mapper;

import com.rest.travelagency.dao.City;
import com.rest.travelagency.domain.city.CityDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityMapper {

    public List<CityDto> mapToCityDtoList(final List<City> cityList) {
        return cityList.stream()
                .map(city1 -> new CityDto(city1.getName()))
                .collect(Collectors.toList());
    }
}
