package com.helloxin.multi.configure.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="com.helloxin")
public class OperatorBean {
	
	private String operatorCode;
	
	private String operatorName;

}
