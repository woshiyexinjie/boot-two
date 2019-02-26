package com.helloxin.reactive.eshop.service;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.helloxin.reactive.eshop.bean.Person;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, Long> {

}
