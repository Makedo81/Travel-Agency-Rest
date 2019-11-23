package com.rest.travelagency.service.booking;

import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.dao.Payment;
import com.rest.travelagency.dao.User;
import com.rest.travelagency.exceptions.NotMatchingDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

public class PaymentProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentProcessor.class);

    public boolean validatePayment(User user, Booking booking, Payment payment, Long cardNumber, Long cardVcs)throws NotMatchingDataException {
        if (user.isSignIn()) {
            String cvcLenght = String.valueOf(cardVcs);
            if (cvcLenght.length() > 3) {
                LOGGER.error("cardVCS code should contain only 3 digits");
                throw new NotMatchingDataException("cardVCS has incorrect digits number");
            }else
                setPayment(booking,payment, cardNumber,cardVcs);
            return true;
        }else  LOGGER.info("User must login to be able to pay");
        return false;
    }

    public void setPayment(Booking booking,Payment payment,Long card,Long vcs) {

        if(!isPaid(booking)) {
            booking.setPaid(true);
            booking.setPaymentStatus("closed");
            payment.setBooking(booking);
            payment.setCardNumber(card);
            payment.setCvcCard(vcs);
            payment.setUser(booking.getUser());
            payment.setDate(new Date());
            payment.setTotalPayment((long) booking.getTotalBookingPrice());
        }
    }

    private boolean isPaid(Booking booking) {
        return booking.getPaymentStatus().equals("closed");
    }
}


