package com.rest.travelagency.mapper;

import com.rest.travelagency.dao.Deal;
import com.rest.travelagency.domain.deal.DealDto;
import org.springframework.stereotype.Component;

@Component
public class DealMapper {

    public DealDto mapToDealDto(Deal deal) {
        return new DealDto(
                deal.getHotel().getName(),
                deal.getDateFrom(),
                deal.getDateTo(),
                deal.getPriceExcludingMeal()
        );
    }
}
