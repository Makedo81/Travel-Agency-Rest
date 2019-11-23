package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@org.hibernate.annotations.NamedQuery(
        name = "MealPrice.findByHotelCityAndMealType",
        query = "From MealPrice where hotel.name = :HOTEL and hotel.city.name = :CITY and mealType.meal = :TYPE "
)
@org.hibernate.annotations.NamedQuery(
        name = "MealPrice.findPriceByHotelIdAndMealId",
        query = "From MealPrice where hotel.id = :ID  and mealType.id = :TYPE "
)

@org.hibernate.annotations.NamedQuery(
        name = "MealPrice.findByHotelId",
        query = "From MealPrice where hotel.id = :ID "
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEALS_PRICES")
public class MealPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEAL_PRICE_ID")
    private Long id;

    @Column(name = "PRICE")
    private int price;

    @ManyToOne
    @JoinColumn(name = "MEAL_TYPE_ID")
    private MealType mealType;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealPrice mealPrice = (MealPrice) o;
        if (getPrice() != mealPrice.getPrice()) return false;
        if (!getId().equals(mealPrice.getId())) return false;
        if (!getMealType().equals(mealPrice.getMealType())) return false;
        return getHotel() != null ? getHotel().equals(mealPrice.getHotel()) : mealPrice.getHotel() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getPrice();
        result = 31 * result + getMealType().hashCode();
        result = 31 * result + (getHotel() != null ? getHotel().hashCode() : 0);
        return result;
    }
}
