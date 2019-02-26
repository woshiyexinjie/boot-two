package com.helloxin.reactive.eshop.service;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.helloxin.reactive.eshop.bean.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, Long>{

}
