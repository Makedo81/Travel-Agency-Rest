package com.rest.travelagency.service;

import com.rest.travelagency.dao.Hotel;
import com.rest.travelagency.dao.HotelDao;
import com.rest.travelagency.dao.MealPrice;
import com.rest.travelagency.dao.MealPriceDao;
import com.rest.travelagency.domain.meal.MealDto;
import com.rest.travelagency.mapper.MealPriceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealService.class);

    @Autowired
    MealPriceDao mealPriceDao;
    @Autowired
    HotelDao hotelDao;
    @Autowired
    MealPriceMapper mealPriceMapper;

    public List<MealDto> findAvailableMeals(final String hotelName) {
        List<Hotel> hotels = hotelDao.findHotelByName(hotelName);
        Long id = hotels.get(0).getId();
        List<MealPrice> mealsPriceList = mealPriceDao.findByHotelId(id);
        for (MealPrice mealPrice : mealsPriceList) {
            LOGGER.info(mealPrice.getHotel().getName() + mealPrice.getMealType().getMeal() + mealPrice.getHotel().getId());
        }
        return mealPriceMapper.mapToMealPriceDtoList(mealsPriceList);
    }
}
