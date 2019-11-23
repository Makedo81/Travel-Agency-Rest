package com.rest.travelagency.controller;

import com.rest.travelagency.domain.meal.MealDto;
import com.rest.travelagency.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/meals")
public class MealController {

    @Autowired
    MealService mealService;

    @RequestMapping(method = RequestMethod.GET, value = "/getMealPrices")
    public List<MealDto> get(@RequestParam String hotelName) {
        return mealService.findAvailableMeals(hotelName);
    }
}
