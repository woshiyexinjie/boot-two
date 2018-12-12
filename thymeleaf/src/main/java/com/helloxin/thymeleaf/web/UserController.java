package com.helloxin.thymeleaf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helloxin.thymeleaf.dao.UserDao;
import com.helloxin.thymeleaf.dao.UserDao2;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDao2 userDao2;

	@RequestMapping("/insert")
    public void inSertUser( @RequestParam("name") String name, @RequestParam("age") Integer age)  {
		log.info("name={},age={}",name,age);
		userDao.create(name, age);            
    }
	
	@RequestMapping("/delete")
    public void deleteUser( @RequestParam("name") String name)  {
		
		userDao.deleteByName(name);     
       
    }
	
	@RequestMapping("/deleteAllUsers")
    public void deleteAllUsers()  {
		
		userDao.deleteAllUsers();;     
       
    }
	
	@RequestMapping("/getAllUsers")
    public Object getAllUsers()  {
		
		return userDao.getAllUsers();    
       
    }
	
	@RequestMapping("/getUser")
    public Object getUserByName(@RequestParam("name") String name)  {
		
		return userDao2.findByName(name);    
       
    }
	
	
	
	
}
