package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@org.hibernate.annotations.NamedQuery(
        name = "Hotel.findHotelByCountry",
        query = "From Hotel where country.name = :COUNTRY "
)
@org.hibernate.annotations.NamedQuery(
        name = "Hotel.findHotelByName",
        query = "From Hotel where name = :NAME "
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HOTELS")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOTEL_ID")
    private Long id;

    @Column(name = "HOTEL_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @OneToMany(
            targetEntity = MealPrice.class,
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<MealPrice> mealPrices = new ArrayList<>();

    @OneToMany(
            targetEntity = Deal.class,
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Deal> deals;

    public Hotel(String name, Country country, City city, List<MealPrice> mealPrices, List<Deal> deals) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.mealPrices = mealPrices;
        this.deals = deals;
    }

    public Hotel(String name, Country country, City city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public Hotel(Long id, String name, Country country, City city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }
}
