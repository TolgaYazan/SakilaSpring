package com.uniyaz.sakila.core.country.dao;

import com.uniyaz.sakila.core.country.domain.Country;
import com.uniyaz.sakila.core.country.dto.CountryCityCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Repository
public interface CountryDao extends JpaRepository<Country, Long> {

    @Query("select country from Country country where country.country = :countryName")
    public List<Country> findAllByName(@Param("countryName") String countryName);

    @Query(
            "select new com.uniyaz.sakila.core.country.dto.CountryCityCountDto(country.country as countryName, " +
            "       (" +
            "           select  count(*) " +
            "           from    City city " +
            "           where   city.country.id = country.id" +
            "       ) as cityCount) " +
            "from Country country ")

    public List<CountryCityCountDto> findCountryCityCountDto();
}