package com.helloxin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello world!";
    }
}
