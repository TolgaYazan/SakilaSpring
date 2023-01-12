package com.uniyaz.sakila.core.city.dao;


import com.uniyaz.sakila.core.city.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityDao extends JpaRepository<City,Long> {
    @Override
    List<City> findAll();

    @Override
    <S extends City> S save(S entity);

    @Override
    void deleteById(Long id);

    @Override
    Optional<City> findById(Long id);
}
