package com.uniyaz.sakila.core.country.service;

import com.uniyaz.sakila.core.actor.domain.Actor;
import com.uniyaz.sakila.core.country.dao.CountryDao;
import com.uniyaz.sakila.core.country.domain.Country;
import com.uniyaz.sakila.utils.REnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {

    @Autowired
    CountryDao countryDao;

    public ResponseEntity<Map<REnum,Object>> save(Country country){
        Country countrySave=countryDao.save(country);
        Map<REnum,Object> countryList=new LinkedHashMap<>();
        countryList.put(REnum.status,true);
        countryList.put(REnum.result,countrySave);

        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum,Object>> findAll(){
        Map<REnum,Object> countryList=new LinkedHashMap<>();
        countryList.put(REnum.status,true);
        countryList.put(REnum.result,countryDao.findAll());

        return new ResponseEntity(countryList,HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> delete(Long id){
        Map<REnum,Object> countryList=new LinkedHashMap<>();

        try {
            countryDao.deleteById(id);
            countryList.put(REnum.status,true);
            return  new ResponseEntity(countryList,HttpStatus.OK);
        }catch (Exception e){
            countryList.put(REnum.status,false);
            countryList.put(REnum.message,e.getMessage());

            return new ResponseEntity(countryList,HttpStatus.BAD_REQUEST);
        }
    }


}