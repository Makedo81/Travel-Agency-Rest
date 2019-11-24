package com.rest.travelagency.service;

import com.rest.travelagency.AdminConfig;
import com.rest.travelagency.dao.*;
import com.rest.travelagency.domain.booking.SelectedBookingDto;
import com.rest.travelagency.domain.meal.MealDto;
import com.rest.travelagency.exceptions.DoublePaymentException;
import com.rest.travelagency.exceptions.NotMatchingDataException;
import com.rest.travelagency.exceptions.OffertsNotAvailableException;
import com.rest.travelagency.service.booking.BookingService;
import com.rest.travelagency.service.booking.PaymentProcessor;
import com.rest.travelagency.service.email.Mail;
import com.rest.travelagency.service.email.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BookingServiceTestSuites {

    @InjectMocks
    private BookingService bookingService;
    @Mock
    private UserDao userDao;
    @Mock
    private DealDao dealDao;
    @Mock
    private MealPriceDao mealPriceDao;
    @Mock
    private MealTypeDao mealTypeDao;
    @Mock
    private AdminConfig adminConfig;
    @Mock
    private BookingDao bookingDao;
    @Mock
    private PaymentDao paymentDao;
    @MockBean
    Mail mail;
    @MockBean
    PaymentProcessor paymentProcessor;
    @Mock
    private JavaMailSender javaMailSender;
    @Mock
    private SimpleEmailService simpleEmailService;

    @Test
    public void shouldCreateNewBooking() {

        LocalDate inputDate1 = LocalDate.of(2019, 11, 12);
        LocalDate inputDate2 = LocalDate.of(2019, 12, 11);
        LocalDate inputDate3 = LocalDate.of(2019, 11, 15);
        LocalDate inputDate4 = LocalDate.of(2019, 12, 9);

        List<City> cities = new ArrayList<>();
        City warsaw = new City();
        warsaw.setName("Warsaw");
        City krakow = new City();
        krakow.setName("Krakow");
        cities.add(warsaw);
        cities.add(krakow);

        List<Country> countries = new ArrayList<>();
        countries.add(new Country(1L,"Poland",new ArrayList<>(), cities));

        Hotel mariott = new Hotel("Mariott", countries.get(0), warsaw);
        Hotel sobieski = new Hotel("Sobieski", countries.get(0), krakow);

        Deal mariottDeal = new Deal(1L,inputDate3, inputDate4, 2, 3, mariott, new ArrayList<>());
        Deal sobieskiDeal = new Deal(2L,inputDate1, inputDate2, 2, 1, sobieski, new ArrayList<>());
        Deal mariottDeal2 = new Deal(3L,inputDate3, inputDate4, 2, 3, mariott, new ArrayList<>());

        List<Deal> deals1 = new ArrayList<>();
        deals1.add(mariottDeal);
        deals1.add(mariottDeal2);
        deals1.add(sobieskiDeal);

        List<MealPrice> mealPriceList = new ArrayList<>();
        MealType meal = new MealType();
        meal.setMeal("breakfast");
        mealPriceList.add(new MealPrice(1L,8, meal, mariott));
        MealType dinner = new MealType();
        dinner.setMeal("dinner");
        MealType breakfast = new MealType();
        breakfast.setMeal("breakfast");

        mealPriceList.add(new MealPrice(1L,8, dinner, mariott));
        mealPriceList.add(new MealPrice(2L,8, breakfast, mariott));

        User john = new User(1L,"John", "Adams", "john@mail", 123L, "johnLogin", "johnPassword",true, new ArrayList<>());

        SelectedBookingDto bookingDto = new SelectedBookingDto("Mariott", "Warsaw", inputDate3, inputDate4, 270, 650, new MealDto("breakfast", 8));

        when(mealTypeDao.findByType("breakfast")).thenReturn(meal);
        when(mealPriceDao.findByHotelCityAndMealType("Mariott", "Warsaw", "breakfast")).thenReturn(mealPriceList);
        when(dealDao.findAll()).thenReturn(deals1);
        when(userDao.findByLogin("johnLogin")).thenReturn(john);

        Booking bookingResult = null;
        try {
            bookingResult = bookingService.addReservation(bookingDto, "johnLogin");
        } catch (OffertsNotAvailableException offertsNotAvailableException) {
            offertsNotAvailableException.printStackTrace();
        }

        assertEquals("Mariott", bookingResult.getDeal().getHotel().getName());
        assertEquals("breakfast", bookingResult.getMealType().getMeal());
        assertEquals("johnLogin", bookingResult.getUser().getLogin());
        assertEquals(inputDate3.getDayOfMonth(), bookingResult.getDeal().getDateFrom().getDayOfMonth());
    }

    @Test
    public void shouldProcessPayment()  {
        //Given
        User john = new User(
                1L,
                "John",
                "Adams",
                "john@mail",
                123L,
                "johnLogin",
                "testPassword",
                true,
                new ArrayList<>());

        List<Deal> deals1 = new ArrayList<>();
        List<MealPrice> mealPriceList = new ArrayList<>();

        Country country = new Country(1L,"England",new ArrayList<>(), new ArrayList<>());
        City london = new City();
        london.setName("London");

        Hotel mariott = new Hotel(1L, "Mariott", country, london, mealPriceList, deals1);
        Hotel sobieski = new Hotel(2L, "Sobieski", country, london, mealPriceList, deals1);

        LocalDate inputDate1 = LocalDate.of(2019, 11, 15);
        LocalDate inputDate2 = LocalDate.of(2019, 11, 17);
        LocalDate inputDate3 = LocalDate.of(2019, 11, 1);
        LocalDate inputDate4 = LocalDate.of(2019, 11, 2);

        Deal mariottDeal = new Deal(1L,inputDate3, inputDate4, 240, 3, mariott, new ArrayList<>());
        Deal sobieskiDeal = new Deal(2L,inputDate1, inputDate2, 100, 1, sobieski, new ArrayList<>());
        Deal mariottDeal2 = new Deal(3L,inputDate3, inputDate4, 50, 3, mariott, new ArrayList<>());

        deals1.add(mariottDeal);
        deals1.add(mariottDeal2);
        deals1.add(sobieskiDeal);

        MealType dinner = new MealType();
        dinner.setMeal("dinner");
        MealType breakfast = new MealType();
        breakfast.setMeal("breakfast");
        mealPriceList = new ArrayList<>();

        mealPriceList.add(new MealPrice(1L,8, dinner, mariott));
        mealPriceList.add(new MealPrice(2L,8, breakfast, mariott));

        Booking booking = new Booking(

                240,
                8,
                540,
                new Date(),
                false,
                "open",
                "gh123",
                breakfast,
                john,
                new Deal(1L,inputDate3, inputDate4, 240, 2, mariott,new ArrayList<>()));

        when(bookingDao.findByBookingCode("gh123")).thenReturn(booking);
        when(userDao.findByLogin("john@mail")).thenReturn(john);
        when(adminConfig.getAdminMail()).thenReturn("makedo919@gmail.com");
        when(bookingDao.save(any(Booking.class))).thenReturn(booking);
        try {
            try {
                bookingService.pay("gh123", "john@mail", 123456L, 789L);
            } catch (NotMatchingDataException e) {
                e.printStackTrace();
            }
        } catch (OffertsNotAvailableException o) {
            o.printStackTrace();
        }

        verify(bookingDao, times(1)).save(booking);
        assertTrue(booking.isPaid());
        assertEquals("closed",booking.getPaymentStatus());
        assertEquals(1,booking.getDeal().getOffertsNumber());
    }
}
