package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.Subscriberdto;
import com.example.demo.model.Subscriber;

public interface SubscriberService {
	public List<Subscriber> getAllSubscriber();
	public MessageResponse addNewSubscriber(Subscriberdto subscriber);

}
