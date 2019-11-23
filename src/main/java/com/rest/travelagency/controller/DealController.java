package com.rest.travelagency.controller;

import com.rest.travelagency.domain.booking.PriceDto;
import com.rest.travelagency.domain.deal.DealDto;
import com.rest.travelagency.service.deal.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/deal")
public class DealController {

    @Autowired
    private DealService dealService;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public List<DealDto> getDeals(@RequestParam String country,
                                  @RequestParam String city,
                                  @RequestParam LocalDate dateFrom,
                                  @RequestParam LocalDate dateTo) {
        return dealService.showDeals(country, city, dateFrom, dateTo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPrice")
    public PriceDto getPriceIncludingMeal(@RequestParam LocalDate dateFrom,
                                          @RequestParam LocalDate dateTo,
                                          @RequestParam String cityName,
                                          @RequestParam int mealPrice) {
        return dealService.getPrice(dateFrom, dateTo, cityName, mealPrice);
    }
}
