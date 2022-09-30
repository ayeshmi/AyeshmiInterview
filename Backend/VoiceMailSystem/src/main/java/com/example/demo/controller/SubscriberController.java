package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Subscriber;
import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.Subscriberdto;
import com.example.demo.service.SubscriberServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/auth")
public class SubscriberController {
	
	@Autowired
	private SubscriberServiceImpl subscriberService;
	
	
	@PostMapping("/newSubscriber")
	public ResponseEntity<Object> addNewSubscriber(@RequestBody Subscriberdto subscriber) {
		MessageResponse message = subscriberService.addNewSubscriber(subscriber);

		if (message.getMessage().equals("Subscriber Successfully registered!")) {
			return ResponseEntity.ok(message);
		} else {
			return ResponseEntity.badRequest().body(message);
		}

	}
	
	@GetMapping("/allSubscribers")
	public ResponseEntity<Object> getAllSubascribers() {
		List<Subscriber> users = subscriberService.getAllSubscriber();
		if (users.size() != 0) {
			return ResponseEntity.ok(users);
		} else {
			MessageResponse message = new MessageResponse("No Records found!");
			return ResponseEntity.badRequest().body(message);
		}
	}


}
