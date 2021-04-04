package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;

@Service
public class FakeService {

	static List<Book> list = new ArrayList();

//	static {
//		list.add(new Book(1, "gaurav", "This is a book"));
//		list.add(new Book(2, "gaurav2", "This is a book"));
//		list.add(new Book(3, "gaurav3", "This is a book"));
//	}

	public List<Book> getAllBooks() {
		return list;
	}

	public Book getASingleBook(int id) {
		Book book= null;
		
		try {
			book= list.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public Book saveAndUpdateASingleBook(Book b) {
		list.add(b);
		return b;
	}

	public void deleteASingleBook(int id) {
		list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
	}

//	public void updateSingleBook(Book b, int id) {
//		list = list.stream().map(e -> {
//			if (e.getId() == id) {
//				e.setAddress(b.getAddress());
//				e.setName(b.getName());
//			}
//			return e;
//		}).collect(Collectors.toList());
//	}

}
