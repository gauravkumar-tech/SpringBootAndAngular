package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class RepositoryTestController {

	@Autowired
	private BookRepository bookrepository;
	
	
	@GetMapping("/bookrepo")
	public ResponseEntity<List<Book>> itWillReturnListOfBook() {

		List<Book> books = (List<Book>)bookrepository.findAll();

		if (books.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(books));

	}
	
	@GetMapping("/bookrepo/{id}")
	public ResponseEntity<Book> itWillReturnSingleBook(@PathVariable("id") int id) {
		Book b = null;
		b = bookrepository.findById(id);

		if (b == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(b));
	}
	
	
	@PostMapping("/bookrepo")
	public ResponseEntity<Book> saveIt(@RequestBody Book b) {
		Book bok = null;

		try {
			bok = bookrepository.save(b);
			return ResponseEntity.status(HttpStatus.CREATED).body(bok);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PutMapping("/bookrepo/{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity updateTheBookByID(@RequestBody Book b, @PathVariable("id") int id) {
		try {
			bookrepository.save(b);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/bookrepo/{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteBookById(@PathVariable("id") int id) {

		try {
			bookrepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
}
