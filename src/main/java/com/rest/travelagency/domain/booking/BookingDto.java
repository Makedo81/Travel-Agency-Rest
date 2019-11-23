package com.rest.travelagency.domain.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private String firstname;
    private String lastname;
    private int price;
    private String hotelName;
    private String mealType;
    private int mealPrice;
    private int totalPrice;
    private String bookingCode;
    private String from;
    private String to;

    public BookingDto(String firstname, String lastname, int price, String hotelName, String mealType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.price = price;
        this.hotelName = hotelName;
        this.mealType = mealType;
    }
}