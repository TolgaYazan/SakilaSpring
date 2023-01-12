package com.uniyaz.sakila.rest.customer;

import com.uniyaz.sakila.core.customer.domain.Customer;
import com.uniyaz.sakila.core.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(path= "save")
    public ResponseEntity save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @GetMapping(path = "findAll")
    public ResponseEntity findAll(){
        return customerService.findAll();
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity delete(@RequestParam Long id){
        return customerService.delete(id);
    }
}
