package com.example.bookmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BOOK")
//@Data
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	private String id;

	@Column(name = "BOOK_NAME")
	private String name;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "AVAILABLE_COPIES")
	private Integer availableCopies;

	@Column(name = "TOTAL_COPIES")
	private Integer totalCopies;

	public Book() {
		super();
	}

	public Book(String id, String name, String author, Integer availableCopies, Integer totalCopies) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.availableCopies = availableCopies;
		this.totalCopies = totalCopies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	public Integer getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}
	
}
