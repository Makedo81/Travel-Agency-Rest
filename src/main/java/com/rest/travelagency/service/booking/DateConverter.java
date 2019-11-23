package com.rest.travelagency.service.booking;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {

    public LocalDate convertToLocalDate() {
        Date date = new Date();
        LocalDate dateOfBooking = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return dateOfBooking;
    }
}
