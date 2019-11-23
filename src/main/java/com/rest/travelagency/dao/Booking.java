package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@org.hibernate.annotations.NamedQuery(
        name = "Booking.findByEmail",
        query = "From Booking where user.email = :EMAIL "
)

@org.hibernate.annotations.NamedQuery(
        name = "Booking.deleteById",
        query = "From Booking where id = :ID "
)

@org.hibernate.annotations.NamedQuery(
        name = "Booking.findByBookingCode",
        query = "From Booking where bookingCode = :BOOKINGCODE "
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKINGS")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKING_ID")
    private Long id;
    @Column(name = "PRICE_EXCL_MEAL")
    private int dealPriceExcludingMeal;
    @Column(name = "MEAL_PRICE")
    private int mealPrice;
    @Column(name = "FINAL_PRICE")
    private int totalBookingPrice;
    @Column(name = "BOOKING_DATE")
    private Date bookingDate;
    @Column(name = "PAID")
    private boolean paid;
    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;
    @Column(name = "BOOKING_CODE")
    private String bookingCode;

    @ManyToOne
    @JoinColumn(name = "MEAL_ID")
    private MealType mealType;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "DEAL_ID")
    private Deal deal;

    public Booking(int dealPriceExcludingMeal, MealType mealType, int mealPrice, User user, Deal deal) {
        this.dealPriceExcludingMeal = dealPriceExcludingMeal;
        this.mealType = mealType;
        this.mealPrice = mealPrice;
        this.user = user;
        this.deal = deal;
    }

    public Booking(int dealPriceExcludingMeal, int mealPrice, int totalBookingPrice, Date bookingDate, boolean paid, String paymentStatus, String bookingCode, MealType mealType, User user, Deal deal) {
        this.dealPriceExcludingMeal = dealPriceExcludingMeal;
        this.mealPrice = mealPrice;
        this.totalBookingPrice = totalBookingPrice;
        this.bookingDate = bookingDate;
        this.paid = paid;
        this.paymentStatus = paymentStatus;
        this.bookingCode = bookingCode;
        this.mealType = mealType;
        this.user = user;
        this.deal = deal;
    }
}
