package com.rest.travelagency.service.booking;

import com.rest.travelagency.AdminConfig;
import com.rest.travelagency.dao.*;
import com.rest.travelagency.domain.booking.BookingDto;
import com.rest.travelagency.domain.booking.FinalPriceDto;
import com.rest.travelagency.domain.booking.PaymentStatusDto;
import com.rest.travelagency.domain.booking.SelectedBookingDto;
import com.rest.travelagency.exceptions.NotMatchingDataException;
import com.rest.travelagency.exceptions.OffertsNotAvailableException;
import com.rest.travelagency.mapper.BookingMapper;
import com.rest.travelagency.service.email.SimpleEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DealDao dealDao;
    @Autowired
    private MealPriceDao mealPriceDao;
    @Autowired
    private MealTypeDao mealTypeDao;
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private SimpleEmailService simpleEmailService;
    @Autowired
    private PaymentDao paymentDao;
    private DealFilter dealFilter = new DealFilter();
    private MailCreator mailCreator = new MailCreator();
    private CodeGenerator codeGenerator = new CodeGenerator();
    private OffertsCalculator offertsCalculator = new OffertsCalculator();
    private PriceCalculator priceCalculator = new PriceCalculator();
    private PaymentProcessor paymentProcessor = new PaymentProcessor();

    public Booking addReservation(final SelectedBookingDto selectedBookingDto,final String loginValue) throws OffertsNotAvailableException {

        User user = userDao.findByLogin(loginValue);
        Booking booking = new Booking();
        booking.setBookingDate(new Date());
        booking.setPaymentStatus("open");
        List<Deal> deals = dealDao.findAll();
        Deal deal = dealFilter.filterDeal(deals, selectedBookingDto);
        MealType meal = mealTypeDao.findByType(selectedBookingDto.getMealDto().getMealType());
        List<MealPrice> mealsPriceList = mealPriceDao.findByHotelCityAndMealType(selectedBookingDto.getHotelName(), selectedBookingDto.getCity(), meal.getMeal());

        booking.setDeal(deal);
        booking.setDealPriceExcludingMeal(selectedBookingDto.getPriceExcludingMeal());
        booking.setUser(user);
        booking.setMealType(mealsPriceList.get(0).getMealType());
        booking.setMealPrice(selectedBookingDto.getMealDto().getPrice());
        booking.setBookingCode(codeGenerator.generateCode(user));
        booking.setTotalBookingPrice(selectedBookingDto.getTotalBookingPrice());
        bookingDao.save(booking);
        LOGGER.info("Booking has been succesfuly saved in database");
        return booking;
    }

    public List<BookingDto> getBooking(final String loginValue) {
        User user = userDao.findByLogin(loginValue);
        String userEmail = user.getEmail();
        List<Booking> booking = bookingDao.findByEmail(userEmail);
        return bookingMapper.mapToBookingDtoList(booking);
    }

    public void deleteBooking(final String bookingCode) {
        Booking bookings = bookingDao.findByBookingCode(bookingCode);
        bookingDao.delete(bookings);
    }

    public void pay(final String bookingCode,final String login,final Long cardNumber,final Long cardVcs) throws  OffertsNotAvailableException, NotMatchingDataException {
        Booking booking = bookingDao.findByBookingCode(bookingCode);
        User user = userDao.findByLogin(login);
        Payment payment = new Payment();
        if (paymentProcessor.validatePayment(user, booking, payment, cardNumber, cardVcs)) {
                bookingDao.save(booking);
                paymentDao.save(payment);
                LOGGER.info(" Payment received ");
                String mail = adminConfig.getAdminMail();
                simpleEmailService.send(mailCreator.createMessage(booking, mail));
                if (offertsCalculator.checkDealNumbers(booking)) {
                    dealDao.save(booking.getDeal());
                }
        }
    }

    public PaymentStatusDto getPaymentStatus(final String bookingCode) {
        PaymentStatusDto status = new PaymentStatusDto();
        Booking booking = bookingDao.findByBookingCode(bookingCode);
        status.setPaymentStatus(booking.getPaymentStatus());
        return status;
    }

    public FinalPriceDto calculatePrice(final String bookingCode) {
        Booking selectedBooking = bookingDao.findByBookingCode(bookingCode);
        return priceCalculator.calculatePriceForSelectedItem(selectedBooking);
    }

    public void update(final String bookingCode,final String value1) throws OffertsNotAvailableException {
        Booking reservation = bookingDao.findByBookingCode(bookingCode);
        Booking booking = bookingDao.findByBookingCode(bookingCode);
        Long id = booking.getDeal().getHotel().getId();
        MealType meal = mealTypeDao.findByType(value1);

        List<MealPrice> mealsPrice = mealPriceDao.findPriceByHotelIdAndMealId(id, meal.getId());
        LOGGER.info(meal.getMeal() + meal.getId());
        if (reservation.getPaymentStatus().equals("open")) {
            switch (value1) {
                case "ONLY_BREAKFAST":
                case "ONLY_DINNER":
                case "BREAKFAST_LUNCH_DINNER":
                case "NO_MEAL":
                    LOGGER.info(value1 + " is to update");
                    reservation.setMealType(meal);
                    reservation.setMealPrice(mealsPrice.get(0).getPrice());
                    bookingDao.save(reservation);
                    FinalPriceDto price = calculatePrice(bookingCode);
                    LOGGER.info("Price has been updated" + price.getFinalPriceDto().intValue());
                    reservation.setTotalBookingPrice(price.getFinalPriceDto().intValue());
                    break;
            }
            bookingDao.save(reservation);
        } else throw new OffertsNotAvailableException("Offerts number = 0");
    }
}
