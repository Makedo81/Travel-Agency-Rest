package com.rest.travelagency.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface HotelDao extends CrudRepository<Hotel, Long> {

    @Override
    Hotel save(Hotel hotel);

    List<Hotel> findAll();

    @Query
    List<Hotel> findHotelByName(@Param("NAME") String name);
}
