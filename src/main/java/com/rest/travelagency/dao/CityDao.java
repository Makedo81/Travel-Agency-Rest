package com.rest.travelagency.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CityDao extends CrudRepository<City, Long> {

    List<City> findAllByCountry(@Param("COUNTRY") String country);
}