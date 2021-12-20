package com.example.bookmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.repository.BookRepository;

@WebMvcTest(BookService.class)
public class BookServiceTests {
	
	@MockBean
	private BookRepository bookRepository;
	
	@Autowired
	BookService bookService;
	
	
	
	@Test
	public void getBooksTest() {
		
		List<Book> books = new ArrayList<>();
		Book book = new Book("Book1", "Camel Action", "John", 2, 2);
		books.add(book);
		
		Mockito.when(bookRepository.findAll()).thenReturn(books);
		
		List<Book> expectedBooks = bookService.getBooks();
		
		assertThat(expectedBooks.size()).isGreaterThan(0);
		assertEquals(books, expectedBooks);
	}
	
	@Test
	public void getBookById() {
		Book book = new Book("Book1", "Camel Action", "John", 2, 2);
		
		Mockito.when(bookRepository.getById(book.getId())).thenReturn(book);
		Book expectedBook = bookService.getBook(book.getId());
		
		//assertThat(expectedBook.size()).isGreaterThan(0);
		assertEquals(book, expectedBook);
	}

}
