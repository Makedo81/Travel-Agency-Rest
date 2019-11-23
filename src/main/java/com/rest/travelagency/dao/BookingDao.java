package com.rest.travelagency.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BookingDao extends CrudRepository<Booking, Long> {

    @Override
    Booking save(Booking booking);

    @Override
    void delete(Booking booking);

    @Override
    void deleteById(@Param("ID") Long id);

    List<Booking> findByEmail(@Param("EMAIL") String email);

    Booking findByBookingCode(@Param("BOOKINGCODE") String bookingCode);

    @Override
    long count();

    @Override
    List<Booking> findAll();

}
