package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.VoiceMaildto;
import com.example.demo.model.VoiceMail;
import com.example.demo.service.VoiceMailServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/auth")
public class VoiceMailController {

	@Autowired
	private VoiceMailServiceImpl voiceMailService;
	
	@PostMapping("/newVoiceMail")
	public ResponseEntity<Object> addNewSubscriber(@RequestBody VoiceMaildto voiceMail) {
		MessageResponse message = voiceMailService.addNewVoiceMail(voiceMail);

		if (message.getMessage().equals("VoiceMail Successfully registered!")) {
			return ResponseEntity.ok(message);
		} else {
			return ResponseEntity.badRequest().body(message);
		}

	}
	
	@GetMapping("/allVoiceMail")
	public ResponseEntity<Object> getAllVoiceMail() {
		List<VoiceMail> voiceMails = voiceMailService.getAllVoiceMails();
		if (voiceMails.size() != 0) {
			return ResponseEntity.ok(voiceMails);
		} else {
			MessageResponse message = new MessageResponse("No Records found!");
			return ResponseEntity.badRequest().body(message);
		}
	}
	
	@GetMapping("/getVoiceMailByID/{id}")
	public ResponseEntity<VoiceMail> getUserByID(@PathVariable Long id) {
		VoiceMail voiceMail = voiceMailService.getVoiceMailById(id);
		if(voiceMail.getVoiceMailFilePath() != null) {
			return new ResponseEntity<VoiceMail>(voiceMail, HttpStatus.OK);
		}else {
			return new ResponseEntity<VoiceMail>(voiceMail, HttpStatus.BAD_REQUEST);
		}
		

	}
}
