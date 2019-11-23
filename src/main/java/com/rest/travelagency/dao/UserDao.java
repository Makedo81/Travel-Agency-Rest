package com.rest.travelagency.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User save(User user);

    void deleteById(@Param("ID") Long id);

    @Query
    User findByLoginAndPassword(@Param("LOGIN") String login, @Param("PASSWORD") String password);

    @Query
    User findByLogin(@Param("LOGIN") String login);

    @Query
    User findByPassword(@Param("PASSWORD") String password);

    @Query
    User findUserByEmail(@Param("EMAIL") String email);

    @Query
    User checkUserStatus(@Param("PASS") String password);

}
