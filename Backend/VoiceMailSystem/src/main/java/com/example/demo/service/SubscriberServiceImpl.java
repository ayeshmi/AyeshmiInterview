package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SubscriberRepository;
import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.Subscriberdto;
import com.example.demo.model.Subscriber;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	
	@Autowired
	private SubscriberRepository subscriberRepository;

	public MessageResponse addNewSubscriber(Subscriberdto subscriber) {
		
		if (subscriberRepository.existsByEmail(subscriber.getEmail())) {
			return new MessageResponse("Error: Email is already taken!");
		}else if(subscriberRepository.existsBysubscriberMSISDN(subscriber.getSubscriberMSISDN())){
			return new MessageResponse("Error: SubscriberMSISDN is already taken!");
		}
		
		Subscriber subscriberNew=new Subscriber();
		subscriberNew.setEmail(subscriber.getEmail());
		subscriberNew.setFirstName(subscriber.getFirstName());
		subscriberNew.setLastName(subscriber.getLastName());
		subscriberNew.setSubscriberMSISDN(subscriber.getSubscriberMSISDN());
		subscriberNew.setSubscriberPIN(subscriber.getSubscriberPIN());
		subscriberNew.setVoiceMailAccountStatus(subscriber.getVoiceMailAccountStatus());
		
		subscriberRepository.save(subscriberNew);
		
		return new MessageResponse("Subscriber Successfully registered!");
	}
	
	public List<Subscriber> getAllSubscriber() {

		List<Subscriber> susbscribers = null;
		try {
			susbscribers = subscriberRepository.findAll();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return susbscribers;
	}

}
