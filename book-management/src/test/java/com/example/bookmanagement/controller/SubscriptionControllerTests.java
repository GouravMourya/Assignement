package com.example.bookmanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.bookmanagement.model.Subscription;
import com.example.bookmanagement.service.SubscriptionService;

@WebMvcTest(SubscriptionController.class)
public class SubscriptionControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SubscriptionService subscriptionService;
	
	@Test
	public void getAllSubscriptionTest() throws Exception {
		List<Subscription> subscriptions = new ArrayList<>();
		Subscription subscription = new Subscription("Mohan", LocalDate.now(), null, "Book1");
		subscriptions.add(subscription);
		
		Mockito.when(subscriptionService.getSubscriptions()).thenReturn(subscriptions);

		mockMvc.perform(get("/subscriptions")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].name", Matchers.equalTo("Mohan")));
	}
	
	@Test
	public void getSubscriptionByNameTest() throws Exception {
		
		Subscription subscription = new Subscription("Mohan", LocalDate.of(2021, 12, 8), null, "Book1");
		Mockito.when(subscriptionService.getSubscriptionById(subscription.getName())).thenReturn(subscription);
		
		MvcResult requestResult = mockMvc.perform(get("/subscriptions/{name}","Mohan"))
                .andExpect(status().isOk()).andReturn();

		String result = requestResult.getResponse().getContentAsString();
		String expectedResult = "{\"name\":\"Mohan\",\"dateSubscribed\":\"2021-12-08\",\"dateReturned\":null,\"bookId\":\"Book1\"}";
		
		assertEquals(result, expectedResult);
	}
	
	@Test
    public void createSubscriptionTest() throws Exception {
		Subscription subscription = new Subscription("Mohan", LocalDate.of(2021, 12, 8), null, "Book1");
		
        Mockito.when(subscriptionService.saveSubscription(ArgumentMatchers.any())).thenReturn(subscription);
       
        String json = "{\"name\":\"Mohan\",\"dateSubscribed\":\"2021-12-08\",\"dateReturned\":null,\"bookId\":\"Book1\"}";
        mockMvc.perform(post("/subscriptions").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.equalTo("Mohan")))
                .andExpect(jsonPath("$.bookId", Matchers.equalTo("Book1")));
    }

}
