package com.helloxin.reactive.eshop.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloxin.reactive.eshop.bean.Book;
import com.helloxin.reactive.eshop.service.PersonRepository;

import reactor.core.publisher.Flux;

@RestController
public class BookController {

	PersonRepository bookrepository;
	
	public BookController(PersonRepository repository)
	{
		this.bookrepository = repository;
	}
	
	@GetMapping("/api/books")
	public Flux<Book> getAllBooks()
	{
		return bookrepository.findAll()
				.flatMap(f->Flux.fromIterable(f.getBooks()));
	}
}
