package com.uniyaz.sakila.rest.city;

import com.uniyaz.sakila.core.city.domain.City;
import com.uniyaz.sakila.core.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "city")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping(path= "save")
    public ResponseEntity save(@RequestBody City city){
        return cityService.save(city);
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
