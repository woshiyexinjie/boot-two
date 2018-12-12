package com.helloxin.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helloxin.thymeleaf.exception.CustomException;

@Controller
public class HelloController {
	
    
//    @ResponseBody
//    @RequestMapping("/hello")
//    public String hello() {
//        return "Hello World";
//    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://helloxin.com");
        return "index";
    }
    
    @RequestMapping("/marker")
    public String marker(ModelMap map) {
        map.addAttribute("host", "http://helloxin.com");
        return "marker";
    }
    
    //这样使用 velocity 报错 因为高版本的spring boot 不再支持  要使用的可以换低版本
    @RequestMapping("/velocity")
    public String velocity(ModelMap map) {
        map.addAttribute("host", "http://helloxin.com");
        return "velocity";
    }
    
    @RequestMapping("/exception")
    public String exception(ModelMap map)  {
    	
        throw new CustomException("test global exception hander");
       
    }
    
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    
    

}
