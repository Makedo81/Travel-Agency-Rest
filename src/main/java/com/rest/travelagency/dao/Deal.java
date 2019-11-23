package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@org.hibernate.annotations.NamedQuery(
        name = "Deal.findAllByCountry",
        query = "From Deal where hotel.country.name = :COUNTRY and offertsNumber > 0"
)
@org.hibernate.annotations.NamedQuery(
        name = "Deal.findAllByCountryAndCity",
        query = "From Deal where hotel.country.name = :COUNTRY and hotel.city.name = :CITY"
)
@org.hibernate.annotations.NamedQuery(
        name = "Deal.findByDateAndHotelName",
        query = "From Deal where dateFrom = :STARTDATE and dateTo = :ENDDATE and hotel.name = :NAME "
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DEALS")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEAL_ID")
    private Long id;

    @Column(name = "DATE_FROM")
    private LocalDate dateFrom;

    @Column(name = "DATE_TO")
    private LocalDate dateTo;

    @Column(name = "PRICE_EXCL_MEAL")
    private int priceExcludingMeal;

    @Column(name = "OFFERTS_NUMBER")
    private int offertsNumber;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @OneToMany(
            targetEntity = Booking.class,
            mappedBy = "deal",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    private List<Booking> bookings = new ArrayList<>();
}
