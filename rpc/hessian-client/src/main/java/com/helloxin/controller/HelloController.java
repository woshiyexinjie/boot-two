package com.helloxin.controller;

import com.helloxin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String test(){
        return helloService.sayHello("Andy");
    }
}
