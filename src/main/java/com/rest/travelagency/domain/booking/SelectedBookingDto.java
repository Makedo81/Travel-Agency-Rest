package com.rest.travelagency.domain.booking;

import com.rest.travelagency.domain.meal.MealDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelectedBookingDto {

    private String hotelName;
    private String city;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int priceExcludingMeal;
    private int totalBookingPrice;
    private MealDto mealDto;
}

