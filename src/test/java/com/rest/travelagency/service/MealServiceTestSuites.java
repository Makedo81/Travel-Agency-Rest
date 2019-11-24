package com.rest.travelagency.service;

import com.rest.travelagency.dao.*;
import com.rest.travelagency.domain.meal.MealDto;
import com.rest.travelagency.mapper.MealPriceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MealServiceTestSuites {

    @InjectMocks
    private MealService mealService;
    @Mock
    private MealPriceDao mealPriceDao;
    @Mock
    private MealPriceMapper mealPriceMapper;
    @Mock
    private HotelDao hotelDao;

    @Test
    public void shouldFetchAvailableMealsList() {
        //Given
        List<MealPrice> mealPriceList = new ArrayList<>();

        Country italy = new Country();
        italy.setName("Italy");
        City verona = new City();
        verona.setName("Verona");

        Hotel hilton = new Hotel(1L, "Hilton", italy, verona, mealPriceList, null);
        Hotel laRoma = new Hotel(2L, "LaRoma", italy, verona, mealPriceList, null);
        MealType dinner = new MealType();
        dinner.setMeal("dinner");
        MealType breakfast = new MealType();
        breakfast.setMeal("breakfast");

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hilton);
        hotels.add(laRoma);

        mealPriceList.add(new MealPrice(1L,12, dinner, hilton));
        mealPriceList.add(new MealPrice(2L,8, breakfast, hilton));

        List<MealDto> meals = new ArrayList<>();
        meals.add(new MealDto("breakfast", 8));
        meals.add(new MealDto("dinner", 12));
        Long id = hotels.get(0).getId();
        when(hotelDao.findHotelByName("Hilton")).thenReturn(hotels);
        when(mealPriceDao.findByHotelId(id)).thenReturn(mealPriceList);
        when(mealPriceMapper.mapToMealPriceDtoList(mealPriceList)).thenReturn(meals);
        //When
        List<MealDto> mealsResult = mealService.findAvailableMeals("Hilton");
        //Then
        assertEquals(2, mealsResult.size());
    }
}
