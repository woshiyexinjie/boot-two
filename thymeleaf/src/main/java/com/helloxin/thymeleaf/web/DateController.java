package com.helloxin.thymeleaf.web;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloxin.thymeleaf.dto.UserDto;

@RestController
public class DateController {
	
	@RequestMapping("/localDate")
    public Object localDate()  {
		
		return new UserDto("helloxin",LocalDate.now());
       
       
    }
	
	@RequestMapping(value ="/userxml", produces = MediaType.APPLICATION_XML_VALUE)
    public Object userXml()  {
		
		return new UserDto("helloxin",LocalDate.now());
       
       
    }

}
