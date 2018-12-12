package com.helloxin.thymeleaf.dto;

import lombok.Data;

@Data
public class ErrorDto<T> {
	
	
	public static final Integer OK = 0;
    public static final Integer ERROR = 100;

	private Integer code;
    private String message;
    private boolean success;
    private T data;
    
}
