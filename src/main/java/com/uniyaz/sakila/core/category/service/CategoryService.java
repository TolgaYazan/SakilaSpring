package com.uniyaz.sakila.core.category.service;


import com.uniyaz.sakila.core.actor.domain.Actor;
import com.uniyaz.sakila.core.category.dao.CategoryDao;
import com.uniyaz.sakila.core.category.domain.Category;
import com.uniyaz.sakila.utils.REnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public ResponseEntity<Map<REnum,Object>> save(Category category){
        Category categorySave=categoryDao.save(category);
        Map<REnum,Object> categoryList=new LinkedHashMap<>();
        categoryList.put(REnum.status,true);
        categoryList.put(REnum.result,categorySave);

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum,Object>> findAll(){
        Map<REnum,Object> categoryList=new LinkedHashMap<>();
        categoryList.put(REnum.status,true);
        categoryList.put(REnum.result,categoryDao.findAll());

        return new ResponseEntity(categoryList,HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> delete(Long id){
        Map<REnum,Object> categoryList=new LinkedHashMap<>();

        try {

            categoryDao.deleteById(id);
            categoryList.put(REnum.status,true);
            return  new ResponseEntity(categoryList,HttpStatus.OK);
        }catch (Exception e){
            categoryList.put(REnum.status,false);
            categoryList.put(REnum.message,e.getMessage());

            return new ResponseEntity(categoryList,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Map<REnum,Object>> search(String data) {
        Map<REnum,Object> categoryList=new LinkedHashMap<>();
        categoryList.put(REnum.result, categoryDao.searchCategory(data));
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
}
