package com.helloxin.thymeleaf.vo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	
	
	    @Id
	    @GeneratedValue
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private Integer age;

	    
}
