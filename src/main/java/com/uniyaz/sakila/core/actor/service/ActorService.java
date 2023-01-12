package com.uniyaz.sakila.core.actor.service;

import com.uniyaz.sakila.core.actor.dao.ActorDao;
import com.uniyaz.sakila.core.actor.domain.Actor;
import com.uniyaz.sakila.core.country.domain.Country;
import com.uniyaz.sakila.utils.REnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActorService {

    @Autowired
    ActorDao actorDao;

    public ResponseEntity<Map<REnum,Object>> save(Actor actor){
        Actor actorSave=actorDao.save(actor);
        Map<REnum,Object> actorList=new LinkedHashMap<>();
        actorList.put(REnum.status,true);
        actorList.put(REnum.result,actorSave);

        return new ResponseEntity<>(actorList, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum,Object>> findAll(){
        Map<REnum,Object> actorList=new LinkedHashMap<>();
        actorList.put(REnum.status,true);
        actorList.put(REnum.result,actorDao.findAll());

        return new ResponseEntity(actorList,HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> delete(Long actorId){
        Map<REnum,Object> actorList=new LinkedHashMap<>();

        try {
            actorDao.deleteById(actorId);
            actorList.put(REnum.status,true);
            return  new ResponseEntity(actorList,HttpStatus.OK);
        }catch (Exception e){
            actorList.put(REnum.status,false);
            actorList.put(REnum.message,e.getMessage());

            return new ResponseEntity(actorList,HttpStatus.BAD_REQUEST);
        }
    }

    public List<Actor> findAllByName(String firstName) {
        return actorDao.findAllByName(firstName);
    }

}
