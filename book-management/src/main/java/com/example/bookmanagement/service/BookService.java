package com.example.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getBooks(){
		 return bookRepository.findAll();	
	}
		
	public Book getBook(String bookId) {
		return bookRepository.getById(bookId);
	}

}
