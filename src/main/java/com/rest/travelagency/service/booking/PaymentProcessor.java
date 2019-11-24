package com.rest.travelagency.service.booking;

import com.rest.travelagency.dao.*;
import com.rest.travelagency.exceptions.DoublePaymentException;
import com.rest.travelagency.exceptions.NotMatchingDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class PaymentProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentProcessor.class);

    @Autowired
    BookingDao bookingDao;
    @Autowired
    PaymentDao paymentDao;

    public boolean validatePayment(User user, Booking booking, Payment payment, Long cardNumber, Long cardVcs)throws NotMatchingDataException {
        if (user.isSignIn() && booking.getDeal().getOffertsNumber()>0) {
            String cvcLenght = String.valueOf(cardVcs);
            if (cvcLenght.length() != 3) {
                LOGGER.error("cardVCS code should contain only 3 digits");
                throw new NotMatchingDataException("cardVCS has incorrect digits number");
            }else {
                try {
                    setPayment(booking,payment, cardNumber,cardVcs);
                } catch (DoublePaymentException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }else  LOGGER.info("User must login to be able to pay");
        return false;
    }

    public void setPayment(Booking booking,Payment payment,Long card,Long vcs)  throws DoublePaymentException {

        if(!isPaid(booking)) {
            booking.setPaid(true);
            booking.setPaymentStatus("closed");
            payment.setBooking(booking);
            payment.setCardNumber(card);
            payment.setCvcCard(vcs);
            payment.setUser(booking.getUser());
            payment.setDate(new Date());
            payment.setTotalPayment((long) booking.getTotalBookingPrice());
        }else throw new  DoublePaymentException("Booking is already paid. Payment rejected");
    }

    private boolean isPaid(Booking booking) {
        return booking.getPaymentStatus().equals("closed");
    }
}


