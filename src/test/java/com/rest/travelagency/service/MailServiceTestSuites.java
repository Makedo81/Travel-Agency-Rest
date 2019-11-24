package com.rest.travelagency.service;

import com.rest.travelagency.dao.*;
import com.rest.travelagency.service.email.Mail;
import com.rest.travelagency.service.email.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MailServiceTestSuites {

    @Mock
    private BookingDao bookingDao;
    @Mock
    private JavaMailSender javaMailSender;
    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Test
    public void shouldSendEmail() {
        //Given
        when(bookingDao.count()).thenReturn(1L);
        User john = new User(
                1L,
                "John",
                "Adams",
                "john@mail",
                123L,
                "johnLogin",
                "testPassword",
                true,
                new ArrayList<>());

        Mail mail = new Mail(
                "test@test.com",
                "Test Mail",
                "Testing mailing service");
        Deal deal = new Deal();
        MealType breakfast = new MealType();
        breakfast.setMeal("breakfast");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(new Booking(
                110,
                20,
                520,
                null,
                true,
                "paid",
                "123G",
                breakfast,
                john,
                deal));

        Iterable<Booking> bookings = bookingList;
        List<Booking> list = new ArrayList<>();
        bookings.iterator().forEachRemaining(list::add);

        //When
        when(bookingDao.findAll()).thenReturn(list);
        simpleEmailService.send(mail);
        when(bookingDao.count()).thenReturn(1L);
        SimpleMailMessage result = simpleEmailService.createMessage(mail);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
        assertNotSame((mailMessage), result.getText());
    }
}
