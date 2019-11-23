package com.rest.travelagency.service.booking;

import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.dao.Deal;
import com.rest.travelagency.exceptions.OffertsNotAvailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OffertsCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(OffertsCalculator.class);

    public boolean checkDealNumbers(Booking booking) throws OffertsNotAvailableException {
        int offertsNumber = booking.getDeal().getOffertsNumber();
        Deal deal = booking.getDeal();
        if (offertsNumber == 0) {
            LOGGER.info("No more offerts available");
            throw new OffertsNotAvailableException("Offerts number = 0");
        } else {
            LOGGER.info("Available deal number is reduced");
            deal.setOffertsNumber(offertsNumber - 1);
            return true;
        }
    }
}


