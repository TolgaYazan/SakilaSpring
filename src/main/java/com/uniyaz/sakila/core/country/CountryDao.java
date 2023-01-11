package com.uniyaz.sakila.core.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryDao extends JpaRepository<Country, Long> {

    @Query("select country from Country country where country.country = :countryName")
    public List<Country> findAllByName(@Param("countryName") String countryName);


    @Override
    <S extends Country> S save(S entity);

    Optional<Country> findById(Long id);
}