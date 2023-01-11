package com.uniyaz.sakila.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ali")
public class HelloController {

    @GetMapping(path = "/veli")
    public String hello() {
        return "Hello Veli";
    }

    @RequestMapping(path = "/mehmet")
    public String mehmet() {
        return "Hello Mehmet";
    }
}