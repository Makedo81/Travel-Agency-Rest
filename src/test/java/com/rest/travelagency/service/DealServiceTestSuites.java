package com.rest.travelagency.service;

import com.rest.travelagency.dao.*;
import com.rest.travelagency.domain.deal.DealDto;
import com.rest.travelagency.mapper.DealMapper;
import com.rest.travelagency.service.deal.DealService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DealServiceTestSuites {

    @InjectMocks
    private DealService dealService;
    @Mock
    private DealDao dealDao;
    @Mock
    private DealMapper dealMapper;

    @Test
    public void testGetAllDeals() {

        LocalDate inputDate1 = LocalDate.of(2019, 11, 12);
        LocalDate inputDate2 = LocalDate.of(2019, 12, 11);
        LocalDate inputDate3 = LocalDate.of(2019, 11, 15);
        LocalDate inputDate4 = LocalDate.of(2019, 12, 9);

        LocalDate d1 = LocalDate.of(2019, 11, 11);
        LocalDate d2 = LocalDate.of(2019, 12, 31);
        List<City> cities = new ArrayList<>();
        City warsaw = new City();
        warsaw.setName("Warsaw");
        City krakow = new City();
        krakow.setName("Krakow");
        cities.add(warsaw);
        cities.add(krakow);
        Country country = new Country();
        country.setName("Poland");
        List<Country> countries = new ArrayList<>();
        countries.add(country);

        Hotel mariott = new Hotel("Mariott", countries.get(0), warsaw);
        Hotel sobieski = new Hotel("Sobieski", countries.get(0), krakow);

        Deal mariottDeal = new Deal(1L,inputDate3, inputDate4, 2, 3, mariott, new ArrayList<>());
        Deal sobieskiDeal = new Deal(2L,inputDate1, inputDate2, 2, 1, sobieski, new ArrayList<>());
        Deal mariottDeal2 = new Deal(3L,inputDate3, inputDate4, 2, 3, mariott, new ArrayList<>());

        List<Deal> deals1 = new ArrayList<>();
        deals1.add(mariottDeal);
        deals1.add(mariottDeal2);
        deals1.add(sobieskiDeal);

        DealDto deal1 = new DealDto("Mariott", inputDate3, inputDate4, 2);
        DealDto deal2 = new DealDto("Mariott", inputDate2, inputDate3, 2);
        DealDto deal3 = new DealDto("Sobieski", inputDate2, inputDate3, 2);

        when(dealDao.findAllByCountry("Poland")).thenReturn(deals1);
        when(dealMapper.mapToDealDto(mariottDeal)).thenReturn(deal1);
        when(dealMapper.mapToDealDto(mariottDeal2)).thenReturn(deal2);
        when(dealMapper.mapToDealDto(sobieskiDeal)).thenReturn(deal3);
        List<DealDto> dealsResult1 = dealService.showDeals("Poland", "Krakow", d1, d2);
        List<DealDto> dealsResult = dealService.showDeals("Poland", "Warsaw", d1, d2);
        assertEquals(2, dealsResult.size());
        assertEquals("Mariott", dealsResult.get(0).getHotelName());
        assertEquals("Mariott", dealsResult.get(1).getHotelName());
        assertEquals(1, dealsResult1.size());
    }

    @Test
    public void testGetPrice() {
        //Given
        List<Deal> deals = new ArrayList<>();
        List<MealPrice> mealPriceList = new ArrayList<>();
        LocalDate inputDate1 = LocalDate.of(2019, 11, 15);
        LocalDate inputDate2 = LocalDate.of(2019, 11, 17);
        Country country = new Country();
        country.setName("London");
        City london = new City();
        london.setName("London");
        Hotel mariott = new Hotel(1L, "Mariott", country, london, mealPriceList, deals);
        Hotel sobieski = new Hotel(2L, "Sobieski", country, london, mealPriceList, deals);

        LocalDate inputDate3 = LocalDate.of(2019, 11, 1);
        LocalDate inputDate4 = LocalDate.of(2019, 11, 2);

        Deal mariottDeal = new Deal(1L,inputDate3, inputDate4, 240, 3, mariott, new ArrayList<>());
        Deal sobieskiDeal = new Deal(2L,inputDate1, inputDate2, 100, 1, sobieski, new ArrayList<>());
        Deal mariottDeal2 = new Deal(3L,inputDate3, inputDate4, 50, 3, mariott, new ArrayList<>());

        deals.add(mariottDeal);
        deals.add(mariottDeal2);
        deals.add(sobieskiDeal);

        when(dealDao.findAll()).thenReturn(deals);
        dealService.getPrice(inputDate1, inputDate2, "London", 12);
        long price = dealService.getPrice(inputDate3, inputDate4, "London", 12).getTotalPrice();

        //When
        dealDao.findAllByCountry(country.getName());

        //Then
        assertEquals(264, price);
    }
}
