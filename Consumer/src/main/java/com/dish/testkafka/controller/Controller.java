package com.dish.testkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.PostLoad;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dish.testkafka.neo4j.business.DataBusiness;

@RestController()
@RequestMapping(value = "/testneo4j")
public class Controller {

    @Autowired
    private DataBusiness business;

    @PostMapping("/merge")
    public String test(@RequestBody String value){

        String resp = business.createObjectWithProperty(value).toString();

        return resp;
    }
    
}
