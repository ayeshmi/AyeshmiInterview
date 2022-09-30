package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber,Long>{
	Boolean existsByEmail(String email);
	Boolean existsBysubscriberMSISDN(String subscriberMSISDN);
	
}
