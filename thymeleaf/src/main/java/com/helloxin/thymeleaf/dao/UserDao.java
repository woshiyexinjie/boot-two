package com.helloxin.thymeleaf.dao;

public interface UserDao {

	void create(String name, Integer age);

	void deleteByName(String name);

	Integer getAllUsers();

	void deleteAllUsers();

}