package com.helloxin.dubbo.provider.service;

import org.springframework.stereotype.Component;


public class ComputeServiceImpl implements ComputeService {

	@Override
	public Integer add(int a, int b) {
		
		return a+b;
	}

}
