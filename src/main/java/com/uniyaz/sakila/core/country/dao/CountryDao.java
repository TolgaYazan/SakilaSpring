package com.uniyaz.sakila.core.country.dao;

import com.uniyaz.sakila.core.actor.domain.Actor;
import com.uniyaz.sakila.core.country.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryDao extends JpaRepository<Country, Long> {

   /* @Query("select country from Country country where country.country = :countryName")
    public List<Country> findAllByName(@Param("countryName") String countryName);*/


    @Override
    List<Country> findAll();

    @Override
    <S extends Country> S save(S entity);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Country> findById(Long id);
}