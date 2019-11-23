package com.rest.travelagency.service.deal;

import com.rest.travelagency.domain.booking.PriceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class DealPriceCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealPriceCalculator.class);

    public PriceDto calculateDealPrice(final LocalDate dateFrom,final LocalDate dateTo,final int mealPrice,final int dealPrice){
        LOGGER.info("Price is calculated");
        long period = DAYS.between(dateFrom, dateTo) + 1;
        Long total;
        if (mealPrice == 0) {
            total = (mealPrice * period) + dealPrice;
            LOGGER.info("Calculated price :" + total + "for period " + period + " days");
        } else {
            total = ((mealPrice * period) + dealPrice);
            LOGGER.info("Calculated price : " + (mealPrice * period) + dealPrice);
            if (total < 0) {
                LOGGER.error("Price is lower than 0");
                throw new IllegalStateException("Price is not correct. Check period");
            } else {
                LOGGER.info("Calculated price :" + total + "for period " + period + " days");
            }
        }
        return new PriceDto(total);
    }
}


