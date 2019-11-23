package com.rest.travelagency.controller;

import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.domain.booking.BookingDto;
import com.rest.travelagency.domain.booking.FinalPriceDto;
import com.rest.travelagency.domain.booking.PaymentStatusDto;
import com.rest.travelagency.domain.booking.SelectedBookingDto;
import com.rest.travelagency.exceptions.DoublePaymentException;
import com.rest.travelagency.exceptions.NotMatchingDataException;
import com.rest.travelagency.exceptions.OffertsNotAvailableException;
import com.rest.travelagency.mapper.BookingMapper;
import com.rest.travelagency.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingMapper bookingMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public BookingDto addBooking(@RequestBody SelectedBookingDto selectedBookingDto, @RequestParam String loginValue) throws OffertsNotAvailableException {
        Booking reservation = bookingService.addReservation(selectedBookingDto, loginValue);
        return bookingMapper.mapToBookingDto(reservation);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getBooking")
    public List<BookingDto> getBooking(@RequestParam(name = "loginValue") String loginValue) {
        return bookingService.getBooking(loginValue);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public void deleteBooking(@RequestParam String bookingCode) {
        bookingService.deleteBooking(bookingCode);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getStatus")
    public PaymentStatusDto getPaymentStatus(@RequestParam String bookingCode) {
        return bookingService.getPaymentStatus(bookingCode);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pay")
    public void pay(@RequestParam String bookingCode,
                    @RequestParam String loginValue,
                    @RequestParam Long cardNumber,
                    @RequestParam Long cvcNumber) throws DoublePaymentException, OffertsNotAvailableException, NotMatchingDataException {
        bookingService.pay(bookingCode, loginValue, cardNumber, cvcNumber);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getFinalPrice")
    public FinalPriceDto getPrice(@RequestParam String bookingCode) {
        return bookingService.calculatePrice(bookingCode);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateReservation(@RequestParam String bookingCode,
                                  @RequestParam String valueToUpdate) throws OffertsNotAvailableException {
        bookingService.update(bookingCode, valueToUpdate);
    }
}
