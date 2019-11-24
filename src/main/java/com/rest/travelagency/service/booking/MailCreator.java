package com.rest.travelagency.service.booking;

import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.service.email.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MailCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailCreator.class);

    public Mail createMessage(Booking booking, String adminMail) {
        Mail mail = new Mail(
                adminMail,
                "Payment confirmation at Travel Agency ",
                "" + booking.getUser().getFirstname()
                        + " "
                        + booking.getUser().getLastname()
                        + " paid for reservation : BOOKING NUMBER: "
                        + booking.getBookingCode()
                        + " for period from " + booking.getDeal().getDateFrom()
                        + " to " + booking.getDeal().getDateTo()
                        + " in hotel " + booking.getDeal().getHotel().getName()
                        + " in " + booking.getDeal().getHotel().getCountry().getName()
                        + " Total price : " + booking.getTotalBookingPrice()
                        + " euro");
        LOGGER.info("Mail with payments details has been created");
        return mail;
    }
}


