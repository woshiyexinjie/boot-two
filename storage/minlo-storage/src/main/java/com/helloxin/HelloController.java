package com.helloxin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @PostMapping(value = "hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }
}
