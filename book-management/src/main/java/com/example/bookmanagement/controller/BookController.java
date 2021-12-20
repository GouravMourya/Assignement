package com.example.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.service.BookService;

@RestController("Library Books APIs")
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getBooks();
	}
	
	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable String bookId){
		return bookService.getBook(bookId);
	}

}
