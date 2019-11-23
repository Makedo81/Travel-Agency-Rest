package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "City.findAllByCountry",
        query = "SELECT distinct  c.* from Cities c inner join country_city cc on cc.city_id=c.city_id inner join Countries co on co.country_id=cc.country_id where co.country in (:COUNTRY)",
        resultClass = City.class
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CITIES")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CITY_ID")
    private Long id;

    @Column(name = "CITY")
    private String name;

    @OneToMany(
            targetEntity = Hotel.class,
            mappedBy = "city",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Hotel> hotels = new ArrayList<>();

    @ManyToMany()
    @JoinTable(
            name = "country_city",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> countries = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        if (!name.equals(city.name)) return false;
        return countries.equals(city.countries);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + countries.hashCode();
        return result;
    }
}
