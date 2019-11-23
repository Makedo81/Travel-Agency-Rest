package com.rest.travelagency.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CountryDao extends CrudRepository<Country, Long> {

    @Override
    List<Country> findAll();
}
