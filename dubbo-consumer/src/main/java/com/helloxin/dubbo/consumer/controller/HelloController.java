package com.helloxin.dubbo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helloxin.dubbo.consumer.service.CalculateServive;

@RestController
public class HelloController { 
 
	@Autowired
	CalculateServive calculateServive;
	
 
    @RequestMapping(value="/hello", method=RequestMethod.GET) 
    public int getUserList() { 
        
        return calculateServive.add(10,20);
    } 
 
}
