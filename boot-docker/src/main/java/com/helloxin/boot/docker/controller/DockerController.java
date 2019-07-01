package com.helloxin.boot.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
    @GetMapping("/")
    public String hello() {
        return "Hello Docker!";
    }
}