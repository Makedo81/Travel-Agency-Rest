package com.rest.travelagency.mapper;

import com.rest.travelagency.dao.Booking;
import com.rest.travelagency.domain.booking.BookingDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

    public List<BookingDto> mapToBookingDtoList(final List<Booking> bookingList) {
        return bookingList.stream()
                .map(booking1 -> new BookingDto(
                        booking1.getUser().getFirstname(),
                        booking1.getUser().getLastname(),
                        booking1.getDealPriceExcludingMeal(),
                        booking1.getDeal().getHotel().getName(),
                        booking1.getMealType().getMeal(),
                        booking1.getMealPrice(),
                        booking1.getTotalBookingPrice(),
                        booking1.getBookingCode(),
                        booking1.getDeal().getDateFrom().toString(),
                        booking1.getDeal().getDateTo().toString()))
                .collect(Collectors.toList());
    }

    public BookingDto mapToBookingDto(final Booking booking1) {
        return new BookingDto(
                booking1.getUser().getFirstname(),
                booking1.getUser().getLastname(),
                booking1.getDealPriceExcludingMeal(),
                booking1.getDeal().getHotel().getName(),
                booking1.getMealType().getMeal()
        );
    }
}
