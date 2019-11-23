package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@org.hibernate.annotations.NamedQuery(
        name = "Payment.findByBookingCode",
        query = "From Payment where booking.bookingCode = :CODE "
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENTS")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAYMENT_ID")
    private Long id;
    @Column(name = "CARD_NUMBER")
    private Long cardNumber;
    @Column(name = "CARD_CVC")
    private Long cvcCard;
    @Column(name = "PRICE")
    private Long totalPayment;
    @Column(name = "PAYMENT_DATE")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;

    public Payment(Long cardNumber, Long cvcCard, Long totalPayment, User user, Booking booking) {
        this.cardNumber = cardNumber;
        this.cvcCard = cvcCard;
        this.totalPayment = totalPayment;
        this.date = new Date();
        this.user = user;
        this.booking = booking;
    }
}
