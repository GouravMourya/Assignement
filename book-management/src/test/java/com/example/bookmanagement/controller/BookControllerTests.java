package com.example.bookmanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.service.BookService;

@WebMvcTest(BookController.class)
public class BookControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@Test
	public void getAllBooksTest() throws Exception {
		List<Book> books = new ArrayList<>();
		Book book = new Book("Book1", "Camel Action", "John", 2, 2);
		books.add(book);
		
		Mockito.when(bookService.getBooks()).thenReturn(books);

		mockMvc.perform(get("/books")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].id", Matchers.equalTo("Book1")));

	}
	
	@Test
	public void getBookByIdTest() throws Exception {
		Book book = new Book("Book1", "Camel Action", "John", 2, 2);
		
		Mockito.when(bookService.getBook(book.getId())).thenReturn(book);
		
		MvcResult requestResult = mockMvc.perform(get("/books/{id}","Book1"))
                .andExpect(status().isOk()).andReturn();
		
        String result = requestResult.getResponse().getContentAsString();
        String expectedResult ="{\"id\":\"Book1\",\"name\":\"Camel Action\",\"author\":\"John\",\"availableCopies\":2,\"totalCopies\":2}";

        assertEquals(result, expectedResult);

	}

}
