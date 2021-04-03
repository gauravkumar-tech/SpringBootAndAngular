package com.example.demo;

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

@RestController
public class TestController {

	@Autowired
	private FakeService fakeservice;

	@GetMapping("/book")
	public ResponseEntity<List<Book>> itWillReturnListOfBook() {

		List<Book> books = fakeservice.getAllBooks();

		if (books.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(books));

	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> itWillReturnSingleBook(@PathVariable("id") int id) {
		Book b = null;
		b = fakeservice.getASingleBook(id);

		if (b == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(b));
	}

	@PostMapping("/book")
	public ResponseEntity<Book> saveIt(@RequestBody Book b) {
		Book bok = null;

		try {
			bok = fakeservice.saveAndUpdateASingleBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).body(bok);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping("/book/{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteBookById(@PathVariable("id") int id) {

		try {
			fakeservice.deleteASingleBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/book/{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity updateTheBookByID(@RequestBody Book b, @PathVariable("id") int id) {
		try {
			fakeservice.updateSingleBook(b, id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
