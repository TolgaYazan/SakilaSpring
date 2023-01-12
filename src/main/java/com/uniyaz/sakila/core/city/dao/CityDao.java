package com.uniyaz.sakila.core.city.dao;

import com.uniyaz.sakila.core.city.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao extends JpaRepository<City,Long> {


    @Query(
            "Select             city " +
            "from               City city " +
            "Left Join fetch    city.country country")
    List<City> findAll();
}
