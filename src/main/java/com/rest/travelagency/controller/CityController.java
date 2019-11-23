package com.rest.travelagency.controller;

import com.rest.travelagency.domain.city.CityDto;
import com.rest.travelagency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("v1/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public List<CityDto> getCity(@RequestParam String country) {
        return cityService.findCities(country);
    }
}
