package com.uniyaz.sakila.core.city.dto;

import com.uniyaz.sakila.core.country.CountryDto;

public class CityDto {

    private Long id;
    private String name;
    private CountryDto countryDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDto getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }
}
