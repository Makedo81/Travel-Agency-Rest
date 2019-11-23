package com.rest.travelagency.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PaymentDao extends CrudRepository<Payment, Long> {

    @Query
    Payment findByBookingCode(@Param("CODE") String bookingCode);
}
