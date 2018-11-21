package com.helloxin.restful.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helloxin.restful.api.bean.Person;

@RestController
public class UserController { 
 
	// 创建线程安全的Map 
    static Map<Long, Person> users = Collections.synchronizedMap(new HashMap<Long, Person>()); 
    
    static {
    	    Person one = new Person("hello","world");
    	    users.put(123456L, one);
    	    Person two = new Person("hi","xin");
    	    users.put(123457L, two);
    }
 
    @RequestMapping(value="/users", method=RequestMethod.GET) 
    public List<Person> getUserList() { 
        
        List<Person> list = new ArrayList<Person>(users.values()); 
        return list; 
    } 
 
}
