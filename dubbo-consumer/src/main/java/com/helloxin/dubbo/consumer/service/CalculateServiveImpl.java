package com.helloxin.dubbo.consumer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.helloxin.dubbo.provider.service.ComputeService;

@Service("calculateServive")
public class CalculateServiveImpl implements CalculateServive{
	
	@Autowired
	private ComputeService computeService;
	
	@Override
	public int add(int a,int b) {
		return computeService.add(a, b);
	}

}
