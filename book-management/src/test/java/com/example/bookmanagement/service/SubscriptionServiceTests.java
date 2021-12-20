package com.example.bookmanagement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.bookmanagement.model.Subscription;
import com.example.bookmanagement.repository.BookRepository;
import com.example.bookmanagement.repository.SubscriptionRepository;

@WebMvcTest(SubscriptionService.class)
public class SubscriptionServiceTests {
	
	@MockBean
	private SubscriptionRepository repository;
	
	@MockBean
	BookRepository bookRepository;
	
	
	@Autowired
	private SubscriptionService service;
	
	@Test
	public void getSubscriptionsTest() {
		
		List<Subscription> subscriptions = new ArrayList<>();
		Subscription subscription = new Subscription("Mohan", LocalDate.of(2021, 12, 8), null, "Book1");
		subscriptions.add(subscription);
		
		Mockito.when(repository.findAll()).thenReturn(subscriptions);
		
		List<Subscription> expectedSubscription = service.getSubscriptions();
		
		assertThat(expectedSubscription.size()).isGreaterThan(0);
		assertEquals(subscriptions, expectedSubscription);
		
	}
	
	@Test
	public void getSubscriptionByIdTest() {
		
		Subscription subscription = new Subscription("Mohan", LocalDate.of(2021, 12, 8), null, "Book1");
		Mockito.when(repository.getById(subscription.getName())).thenReturn(subscription);
		
		Subscription expectedSubscription = service.getSubscriptionById(subscription.getName());
		
		assertEquals(subscription, expectedSubscription);
		
	}

}
