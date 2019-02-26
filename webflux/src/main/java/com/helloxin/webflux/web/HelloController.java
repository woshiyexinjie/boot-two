package com.helloxin.webflux.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController { 

 
    @RequestMapping(value="/hello", method=RequestMethod.GET) 
    public Mono<String> hello() {
        return Mono.just("Welcome to reactive world"); 
    }
 
}
