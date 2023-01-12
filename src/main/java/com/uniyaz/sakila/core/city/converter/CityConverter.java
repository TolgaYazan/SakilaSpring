package com.uniyaz.sakila.core.city.converter;

import com.uniyaz.sakila.core.city.domain.City;
import com.uniyaz.sakila.core.city.dto.CityDto;
import com.uniyaz.sakila.core.country.CountryConverter;
import com.uniyaz.sakila.core.country.CountryDto;
import com.uniyaz.sakila.core.country.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {

    @Autowired
    CountryConverter countryConverter;

    public CityDto convertToCityDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getCity());
        Country country = city.getCountry();
        CountryDto countryDto = countryConverter.convertToCountryDto(country);
        cityDto.setCountryDto(countryDto);
        return cityDto;
    }
}