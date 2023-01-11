package com.uniyaz.sakila.core.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {

    @Autowired
    CountryDao countryDao;

    public List<Country> findAll() {
        return countryDao.findAll();
    }

    public List<Country> findAllByName(String countryName) {
        return countryDao.findAllByName(countryName);
    }

    public Optional<Country> findById(Long id) {
        return countryDao.findById(id);
    }
    public List<Country> save(Country country) {
        Country c=countryDao.save(country);
        List<Country> countryList=new ArrayList<>();
        countryList.add(c);
        return  countryList;
    }


}