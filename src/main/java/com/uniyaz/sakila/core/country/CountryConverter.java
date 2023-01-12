package com.uniyaz.sakila.core.country;

import com.uniyaz.sakila.core.country.domain.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryConverter {

    public CountryDto convertToCountryDto(Country country){
        CountryDto countryDto=new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getCountry());
        return countryDto;
    }

    public List<CountryDto> convertToCountryDtoList(List<Country> countryList){
        List<CountryDto> countryDtoList=new ArrayList<>();

        for (Country country : countryList){
            CountryDto countryDto=convertToCountryDto(country);
            countryDtoList.add(countryDto);
        }
        return countryDtoList;
    }
}
