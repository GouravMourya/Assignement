package com.example.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookmanagement.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String> {

}
