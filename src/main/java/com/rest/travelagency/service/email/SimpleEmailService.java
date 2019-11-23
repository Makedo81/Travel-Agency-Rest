package com.rest.travelagency.service.email;

import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.dao.BookingDao;
import com.rest.travelagency.domain.booking.BookingDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEmailService.class);

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    BookingDao bookingDao;

    private BookingDto bookingDto = new BookingDto();

    public void send(final Mail mail) {
        LOGGER.info("Starting email preparation");
        try {
            SimpleMailMessage mailMessage = createMessage(mail);
            javaMailSender.send(mailMessage);
            LOGGER.info("Email has been sent");
        } catch (MailException e) {
            LOGGER.error("Fail to process email sending", e.getMessage(), e);
        }
    }

    public SimpleMailMessage createMessage(final Mail mail) {
        long size = bookingDao.count();
        System.out.println(size);
        Iterable<Booking> bookings = bookingDao.findAll();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        if (size > 0) {
            if (bookings.iterator().next().getBookingCode().equals(bookingDto.getBookingCode())) {
                mailMessage.setText((
                        "Currently in database you got " + size + " bookings"));
            } else {
                mailMessage.setText((mail.getMessage()));
            }
        } else mailMessage.setText(
                (" Database is empty "));
        return mailMessage;
    }
}
