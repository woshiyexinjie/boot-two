package com.helloxin.multi.configure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloxin.multi.configure.bean.OperatorBean;
import com.helloxin.multi.configure.service.SystemProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {

	@Autowired
	private SystemProperties systemProperties;
	
	
	
    @RequestMapping("/hello")
    public String index() {   	
    	    
    	     
    	    log.info("----------------------------");
    	    OperatorBean operatorBean = new OperatorBean();
    	    log.info("operatorBean tostring={}",operatorBean.toString());
    	
        return systemProperties.getValue();
    }

}
