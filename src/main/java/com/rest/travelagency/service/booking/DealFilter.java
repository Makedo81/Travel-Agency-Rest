package com.rest.travelagency.service.booking;

import com.rest.travelagency.dao.Deal;
import com.rest.travelagency.domain.booking.SelectedBookingDto;
import com.rest.travelagency.exceptions.OffertsNotAvailableException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DealFilter {

    public Deal filterDeal(List<Deal> dealList, SelectedBookingDto selectedBookingDto) throws OffertsNotAvailableException {
        LocalDate date1 = (selectedBookingDto.getDateFrom());
        LocalDate date2 = (selectedBookingDto.getDateTo());
        List<Deal> dealsFiltrated = dealList.stream()
                .filter(a -> a.getOffertsNumber() > 0)
                .filter(d -> d.getHotel().getName().equals(selectedBookingDto.getHotelName()))
                .filter(d1 -> d1.getDateFrom().isEqual(date1))
                .filter(d2 -> d2.getDateTo().isEqual(date2))
                .collect(Collectors.toList());
        if (dealsFiltrated.get(0).getOffertsNumber() == 0) {
            throw new OffertsNotAvailableException(" Offerts number = 0. There are no more offerts available");
        }
        Deal filtratedDeal = dealsFiltrated.get(0);
        return filtratedDeal;
    }
}


