package com.uniyaz.sakila.core.address.service;

import com.uniyaz.sakila.core.address.dao.AddressDao;
import com.uniyaz.sakila.core.address.domain.Address;
import com.uniyaz.sakila.utils.REnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class AddressService {

    @Autowired
    AddressDao addressDao;
    public ResponseEntity<Map<REnum,Object>> save(Address address){
        Address addressSave=addressDao.save(address);
        Map<REnum,Object> addressList=new LinkedHashMap<>();
        addressList.put(REnum.status,true);
        addressList.put(REnum.result,addressSave);

        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }


    public ResponseEntity<Map<REnum,Object>> findAll(){
        Map<REnum,Object> addressList=new LinkedHashMap<>();
        addressList.put(REnum.status,true);
        addressList.put(REnum.result, addressDao.findAll());

        return new ResponseEntity(addressList,HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> delete(Long id){
        Map<REnum,Object> addressList=new LinkedHashMap<>();

        try {
            addressDao.deleteById(id);
            addressList.put(REnum.status,true);
            return  new ResponseEntity(addressList,HttpStatus.OK);
        }catch (Exception e){
            addressList.put(REnum.status,false);
            addressList.put(REnum.message,e.getMessage());

            return new ResponseEntity(addressList,HttpStatus.BAD_REQUEST);
        }
    }

}
