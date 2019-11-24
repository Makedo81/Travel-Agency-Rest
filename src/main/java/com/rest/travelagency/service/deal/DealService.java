package com.rest.travelagency.service.deal;

import com.rest.travelagency.dao.Deal;
import com.rest.travelagency.dao.DealDao;
import com.rest.travelagency.domain.booking.PriceDto;
import com.rest.travelagency.domain.deal.DealDto;
import com.rest.travelagency.mapper.DealMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class DealService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealService.class);

    @Autowired
    private DealDao dealDao;
    @Autowired
    private DealMapper dealMapper;

    private DealPriceCalculator dealPriceCalculator = new DealPriceCalculator();

    public List<DealDto> showDeals(final String country,final String city,final LocalDate dateFrom,final LocalDate dateTo) {

        final List<Deal> deals = dealDao.findAllByCountry(country).stream()
                .filter(d -> d.getOffertsNumber() > 0)
                .filter(d1 -> d1.getDateFrom().isAfter(dateFrom)||d1.getDateFrom().isEqual(dateFrom))
                .filter(d2 -> d2.getDateTo().isBefore(dateTo) || d2.getDateTo().isEqual(dateFrom))
                .filter(d -> d.getHotel().getCity().getName().equals(city))
                .collect(Collectors.toList());
        List<DealDto> dealsDtoList = new ArrayList<>();
        for (Deal deal : deals) {
            dealsDtoList.add(dealMapper.mapToDealDto(deal));
        }
        LOGGER.info("Deals list ready");
        return dealsDtoList;
    }

    public PriceDto getPrice(final LocalDate dateFrom,final LocalDate dateTo,final String city,final int mealPrice) {
        final List<Deal> deals = dealDao.findAll().stream()
                .filter(d1 -> d1.getDateFrom().equals(dateFrom))
                .filter(d2 -> d2.getDateTo().equals(dateTo))
                .filter(d -> d.getHotel().getCity().getName().equals(city))
                .collect(Collectors.toList());

        int dealPrice =  deals.get(0).getPriceExcludingMeal();
        return dealPriceCalculator.calculateDealPrice(dateFrom,dateTo,mealPrice,dealPrice);
    }
}