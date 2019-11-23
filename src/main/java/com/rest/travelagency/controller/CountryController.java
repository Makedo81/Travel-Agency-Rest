package com.rest.travelagency.controller;

import com.rest.travelagency.domain.country.CountryDto;
import com.rest.travelagency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("v1/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public List<CountryDto> getCountry() {
        return countryService.findCountries();
    }
}
