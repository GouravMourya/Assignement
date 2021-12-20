package com.example.bookmanagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SUBSCRIPTION")
//@Data
public class Subscription {
	
	@Id
	@Column(name = "SUBSCRIBER_NAME")
	private String name;

	@Column(name = "DATE_SUBSCRIBED")
	private LocalDate dateSubscribed;
	
	@Column(name = "DATE_RETURNED")
	private LocalDate dateReturned;
	
	//@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "BOOK_ID")
	@Column(name = "BOOK_ID")
    private String bookId;

	public Subscription() {
		super();
	}

	
	public Subscription(String name, LocalDate dateSubscribed, LocalDate dateReturned, String bookId) {
		super();
		this.name = name;
		this.dateSubscribed = dateSubscribed;
		this.dateReturned = dateReturned;
		this.bookId = bookId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateSubscribed() {
		return dateSubscribed;
	}

	public void setDateSubscribed(LocalDate dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}

	public LocalDate getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(LocalDate dateReturned) {
		this.dateReturned = dateReturned;
	}


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	
	
}
