package com.helloxin.service;

import com.helloxin.dao.UserRepository;
import com.helloxin.donain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService { //1
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) { //2
		
		User user = userRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		return user;
	}

}
