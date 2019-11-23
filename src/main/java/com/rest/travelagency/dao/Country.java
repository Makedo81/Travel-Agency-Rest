package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COUNTRY_ID")
    private Long id;

    @Column(name = "COUNTRY")
    private String name;

    @OneToMany(
            targetEntity = Hotel.class,
            mappedBy = "country",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Hotel> hotels = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "country_city",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id"))
    private List<City> cities = new ArrayList<>();

}
