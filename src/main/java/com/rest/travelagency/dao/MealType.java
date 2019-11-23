package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@org.hibernate.annotations.NamedQuery(
        name = "MealType.findByType",
        query = "From MealType where meal = :TYPE "
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEAL_TYPE")
public class MealType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEAL_ID")
    private Long id;

    @Column(name = "MEAL_TYPE")
    private String meal;

    @OneToMany(
            targetEntity = MealPrice.class,
            mappedBy = "mealType",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<MealPrice> mealPrice = new ArrayList<>();

    @OneToMany(
            targetEntity = Booking.class,
            mappedBy = "mealType",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealType mealType = (MealType) o;
        if (!getId().equals(mealType.getId())) return false;
        return getMeal().equals(mealType.getMeal());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getMeal().hashCode();
        return result;
    }
}
