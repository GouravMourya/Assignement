package com.example.bookmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.Subscription;
import com.example.bookmanagement.repository.BookRepository;
import com.example.bookmanagement.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	
	@Autowired
	SubscriptionRepository repository;
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Subscription> getSubscriptions(){
		return repository.findAll();
	}
	
	public Subscription getSubscriptionById(String name){
		return repository.getById(name);
	}
	
	 @Transactional
	 @ResponseBody
	public Object saveSubscription(Subscription subscription) {
		 
		Book book = bookRepository.getById(subscription.getBookId());
		
		Integer availableCopies = book.getAvailableCopies();
		if(availableCopies>0) {
			
			repository.saveAndFlush(subscription);
			bookRepository.updateBookById(--availableCopies, book.getId());
			
			return ResponseEntity.status(HttpStatus.CREATED).body("Subscription is created");
		}else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("No Copies are available");
		}
		
	}

}
