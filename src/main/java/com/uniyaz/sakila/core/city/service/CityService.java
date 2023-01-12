package com.uniyaz.sakila.core.city.service;


import com.uniyaz.sakila.core.actor.domain.Actor;
import com.uniyaz.sakila.core.city.dao.CityDao;
import com.uniyaz.sakila.core.city.domain.City;
import com.uniyaz.sakila.utils.REnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CityService {
    @Autowired
    CityDao cityDao;

    public ResponseEntity<Map<REnum,Object>> save(City city){
        City citySave=cityDao.save(city);
        Map<REnum,Object> cityList=new LinkedHashMap<>();
        cityList.put(REnum.status,true);
        cityList.put(REnum.result,citySave);

        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum,Object>> findAll(){
        Map<REnum,Object> cityList=new LinkedHashMap<>();
        cityList.put(REnum.status,true);
        cityList.put(REnum.result,cityDao.findAll());

        return new ResponseEntity(cityList,HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> delete(Long id){
        Map<REnum,Object> cityList=new LinkedHashMap<>();

        try {
            cityDao.deleteById(id);
            cityList.put(REnum.status,true);
            return  new ResponseEntity(cityList,HttpStatus.OK);
        }catch (Exception e){
            cityList.put(REnum.status,false);
            cityList.put(REnum.message,e.getMessage());

            return new ResponseEntity(cityList,HttpStatus.BAD_REQUEST);
        }
    }
}
