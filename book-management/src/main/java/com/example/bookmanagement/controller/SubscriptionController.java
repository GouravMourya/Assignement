package com.example.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmanagement.model.Subscription;
import com.example.bookmanagement.service.SubscriptionService;

@RestController("Library Subscription APIs")
@RequestMapping("/subscriptions")
public class SubscriptionController {
	
	@Autowired
	SubscriptionService service;
	
	@GetMapping
	public List<Subscription> getAllSubscription(){
		return service.getSubscriptions();
	}
	
	@GetMapping("/{name}")
	public Subscription getSubscriptionByName(@PathVariable String name){
		return service.getSubscriptionById(name);
	}
	
	@PostMapping
	public Object createSubscription(@RequestBody Subscription subscription) {
		return service.saveSubscription(subscription);
	}
}
