package com.rest.travelagency.mapper;

import com.rest.travelagency.dao.MealPrice;
import com.rest.travelagency.domain.meal.MealDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MealPriceMapper {

    public List<MealDto> mapToMealPriceDtoList(final List<MealPrice> priceList) {
        return priceList.stream()
                .map(price1 -> new MealDto(
                        price1.getMealType().getMeal(),
                        price1.getPrice()))
                .collect(Collectors.toList());
    }
}
