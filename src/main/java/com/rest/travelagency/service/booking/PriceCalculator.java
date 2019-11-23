package com.rest.travelagency.service.booking;

import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.domain.booking.FinalPriceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.time.temporal.ChronoUnit.DAYS;

public class PriceCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceCalculator.class);

    public FinalPriceDto calculatePriceForSelectedItem(Booking booking) {
        FinalPriceDto calculatedPrice = new FinalPriceDto();
        int mealPrice = booking.getMealPrice();
        int dealPrice = booking.getDealPriceExcludingMeal();
        long period = (DAYS.between(booking.getDeal().getDateFrom(), booking.getDeal().getDateTo())) + 1;
        Long priceTotal = dealPrice + (mealPrice * period);
        calculatedPrice.setFinalPriceDto(priceTotal);
        return calculatedPrice;
    }
}


