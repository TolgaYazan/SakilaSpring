package com.uniyaz.sakila.core.customer.service;


import com.uniyaz.sakila.core.actor.dao.ActorDao;
import com.uniyaz.sakila.core.actor.domain.Actor;
import com.uniyaz.sakila.core.customer.dao.CustomerDao;
import com.uniyaz.sakila.core.customer.domain.Customer;
import com.uniyaz.sakila.utils.REnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public ResponseEntity<Map<REnum,Object>> save(Customer customer){
        Customer customerSave=customerDao.save(customer);
        Map<REnum,Object> customerList=new LinkedHashMap<>();
        customerList.put(REnum.status,true);
        customerList.put(REnum.result,customerSave);

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    public ResponseEntity<Map<REnum,Object>> findAll(){
        Map<REnum,Object> customerList=new LinkedHashMap<>();
        customerList.put(REnum.status,true);
        customerList.put(REnum.result,customerDao.findAll());

        return new ResponseEntity(customerList,HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> delete(Long id){
        Map<REnum,Object> customerList=new LinkedHashMap<>();

        try {
            customerDao.deleteById(id);
            customerList.put(REnum.status,true);
            return  new ResponseEntity(customerList,HttpStatus.OK);
        }catch (Exception e){
            customerList.put(REnum.status,false);
            customerList.put(REnum.message,e.getMessage());

            return new ResponseEntity(customerList,HttpStatus.BAD_REQUEST);
        }
    }
}
