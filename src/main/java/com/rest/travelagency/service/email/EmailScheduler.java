package com.rest.travelagency.service.email;

import com.rest.travelagency.AdminConfig;
import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    public AdminConfig adminConfig;

    private static final String SUBJECT = "Current reservation status in database";

    //  @Scheduled(fixedDelay = 200000)
    @Scheduled(cron = " 00 10 * * * * ")
    public void sendInformationEmail() throws MailParseException {
        long size = bookingDao.count();
        List<Booking> totalReservationNumber = new ArrayList<>();
        Iterable<Booking> totalReservation = bookingDao.findAll();
        totalReservation.iterator().forEachRemaining(totalReservationNumber::add);
        System.out.println(totalReservationNumber.size());

        List<Booking> open = totalReservationNumber.stream()
                .filter(o -> o.getPaymentStatus().equals("open"))
                .collect(Collectors.toList());

        List<Booking> closed = totalReservationNumber.stream()
                .filter(c -> c.getPaymentStatus().equals("closed"))
                .collect(Collectors.toList());

        Mail mail = new Mail(adminConfig.getAdminMail(),
                SUBJECT,
                "Total reservation number in database: " + size + "." + " Currently there are: " + open.size() + " open reservations and " + closed.size() + " paid reservation.");
        simpleEmailService.send(mail);
    }
}
