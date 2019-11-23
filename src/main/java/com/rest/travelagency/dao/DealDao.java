package com.rest.travelagency.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface DealDao extends CrudRepository<Deal, Long> {

    List<Deal> findAllByCountry(@Param("COUNTRY") String Country);

    List<Deal> findAll();
}
