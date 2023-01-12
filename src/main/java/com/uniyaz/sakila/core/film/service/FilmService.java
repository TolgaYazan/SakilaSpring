package com.uniyaz.sakila.core.film.service;


import com.uniyaz.sakila.core.film.dao.FilmDao;
import com.uniyaz.sakila.core.film.domain.Film;
import com.uniyaz.sakila.utils.REnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class FilmService {

    @Autowired
    FilmDao filmDao;

    public ResponseEntity<Map<REnum,Object>> save(Film film){
        Film filmSave=filmDao.save(film);
        Map<REnum,Object> filmList=new LinkedHashMap<>();
        filmList.put(REnum.status,true);
        filmList.put(REnum.result,filmSave);

        return new ResponseEntity<>(filmList, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum,Object>> findAll(){
        Map<REnum,Object> filmList=new LinkedHashMap<>();
        filmList.put(REnum.status,true);
        filmList.put(REnum.result,filmDao.findAll());

        return new ResponseEntity(filmList,HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> delete(Long id){
        Map<REnum,Object> FilmList =new LinkedHashMap<>();

        try {
            filmDao.deleteById(id);
            FilmList.put(REnum.status,true);
            return  new ResponseEntity(FilmList,HttpStatus.OK);
        }catch (Exception e){
            FilmList.put(REnum.status,false);
            FilmList.put(REnum.message,e.getMessage());

            return new ResponseEntity(FilmList,HttpStatus.BAD_REQUEST);
        }
    }


}