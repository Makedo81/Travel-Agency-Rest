package com.rest.travelagency.service.booking;

import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@EnableScheduling
@Component
public class BookingRemoverScheduler {

    @Autowired
    private BookingDao bookingDao;

    @Scheduled(fixedDelay = 10000)
    public void deleteOldBookings() {

        List<Booking> bookings = bookingDao.findAll();
        List<Booking> openStatus = bookings.stream()
                .filter(o -> o.getPaymentStatus().equals("open"))
                .collect(Collectors.toList());
        for (Booking booking : openStatus) {
            if(isLongerThan10minutes(booking.getBookingDate())){
                bookingDao.delete(booking);
                System.out.println("Bookings not paid longer than 10 minutes removed");
            }
        }
    }

    private boolean isLongerThan10minutes(Date bookingDate){
        long bookingAddedTime = bookingDate.getTime();
        Date currentDate = new Date();
        long durationMilisecond = currentDate.getTime() - bookingAddedTime;
        System.out.println(durationMilisecond);
        long durationSecond = durationMilisecond / 1000;
        return(durationSecond > (10 * 60));
    }
}

