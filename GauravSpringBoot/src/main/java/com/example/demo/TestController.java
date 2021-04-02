package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private FakeService fakeservice;
	
	@GetMapping("/single/{id}")
	public Book itWillReturnSingleBook(@PathVariable("id")int id) {
		 return fakeservice.getASingleBook(id);
	}

	@GetMapping("/listofbooks")
	public List<Book> itWillReturnListOfBook() {
		return fakeservice.getAllBooks();
	}

	@PostMapping("/saveit")
	public Book saveIt(@RequestBody Book b) {
		Book bok=fakeservice.saveAndUpdateASingleBook(b);
		return bok;
	}
	
	@DeleteMapping("/deleteit/{id}")
	public void deleteBookById(@PathVariable("id") int id) {
		fakeservice.deleteASingleBook(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateTheBookByID(@RequestBody Book b,@PathVariable("id") int id) {
		fakeservice.updateSingleBook(b, id);
	}
}
