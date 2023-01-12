package com.uniyaz.sakila.rest.city;

import com.uniyaz.sakila.core.city.converter.CityConverter;
import com.uniyaz.sakila.core.city.domain.City;
import com.uniyaz.sakila.core.city.dto.CityCascadeSaveRequestDto;
import com.uniyaz.sakila.core.city.dto.CityDto;
import com.uniyaz.sakila.core.city.dto.CitySaveRequestDto;
import com.uniyaz.sakila.core.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "city")
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    CityConverter cityConverter;

    @PostMapping(path= "save")
    public ResponseEntity save(@RequestBody CitySaveRequestDto citySaveRequestDto){
        City city = cityService.save(citySaveRequestDto);
        CityDto cityDto = cityConverter.convertToCityDto(city);
        ResponseEntity responseEntity = new ResponseEntity(cityDto, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(path= "saveCascade")
    public ResponseEntity saveCascade(@RequestBody CityCascadeSaveRequestDto cityCascadeSaveRequestDto){
        City city = cityService.save(cityCascadeSaveRequestDto);
        CityDto cityDto = cityConverter.convertToCityDto(city);
        ResponseEntity responseEntity = new ResponseEntity(cityDto, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path = "findAll")
    public ResponseEntity findAll(){
        return cityService.findAll();
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity delete(@RequestParam Long id){
        return cityService.delete(id);
    }

}
