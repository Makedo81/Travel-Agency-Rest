package com.rest.travelagency.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface MealPriceDao extends CrudRepository<MealPrice, Long> {

    @Query
    List<MealPrice> findByHotelId(@Param("ID") long id);

    @Query
    List<MealPrice> findByHotelCityAndMealType(@Param("HOTEL") String name, @Param("CITY") String city, @Param("TYPE") String type);

    @Query
    List<MealPrice> findPriceByHotelIdAndMealId(@Param("ID") long id, @Param("TYPE") long mealId);
}
