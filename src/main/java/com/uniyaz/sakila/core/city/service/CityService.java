package com.uniyaz.sakila.core.city.service;


import com.uniyaz.sakila.core.actor.domain.Actor;
import com.uniyaz.sakila.core.city.dao.CityDao;
import com.uniyaz.sakila.core.city.domain.City;
import com.uniyaz.sakila.core.city.dto.CityCascadeSaveRequestDto;
import com.uniyaz.sakila.core.city.dto.CitySaveRequestDto;
import com.uniyaz.sakila.core.country.domain.Country;
import com.uniyaz.sakila.core.country.service.CountryService;
import com.uniyaz.sakila.utils.REnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityService {

    @Autowired
    CityDao cityDao;

    @Autowired
    CountryService countryService;

    public City save(CitySaveRequestDto citySaveRequestDto) {
//        Long countryId = citySaveRequestDto.getCountryId();
//        Country country = countryService.findById(countryId);
        String cityName = citySaveRequestDto.getName();

        Country country = new Country();
        country.setId(citySaveRequestDto.getCountryId());

        City city = new City();
        city.setCity(cityName);
        city.setCountry(country);
        city.setLastUpdate(new Date());
        return cityDao.save(city);
    }

    public City save(CityCascadeSaveRequestDto cityCascadeSaveRequestDto) {
        String cityName = cityCascadeSaveRequestDto.getCityName();
        String countryName = cityCascadeSaveRequestDto.getCountryName();

        Country country = new Country();
        country.setCountry(countryName);
        country.setLastUpdate(new Date());

        City city = new City();
        city.setCity(cityName);
        city.setCountry(country);
        city.setLastUpdate(new Date());
        return cityDao.save(city);
    }

    public ResponseEntity<Map<REnum, Object>> save(City city) {
        City citySave = cityDao.save(city);
        Map<REnum, Object> cityList = new LinkedHashMap<>();
        cityList.put(REnum.status, true);
        cityList.put(REnum.result, citySave);

        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum, Object>> findAll() {

        List<City> cityList1 = cityDao.findAll();
        City city = cityList1.get(10);
        Country country = city.getCountry();
        System.out.println(country.getCountry());

        Map<REnum, Object> cityMap = new LinkedHashMap<>();
        cityMap.put(REnum.status, true);
        cityMap.put(REnum.result, cityList1);

        return new ResponseEntity(cityMap, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> delete(Long id) {
        Map<REnum, Object> cityList = new LinkedHashMap<>();

        try {
            cityDao.deleteById(id);
            cityList.put(REnum.status, true);
            return new ResponseEntity(cityList, HttpStatus.OK);
        } catch (Exception e) {
            cityList.put(REnum.status, false);
            cityList.put(REnum.message, e.getMessage());

            return new ResponseEntity(cityList, HttpStatus.BAD_REQUEST);
        }
    }
}
