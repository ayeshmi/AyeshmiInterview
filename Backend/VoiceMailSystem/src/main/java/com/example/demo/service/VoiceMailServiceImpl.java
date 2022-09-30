package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.VoiceMaildto;
import com.example.demo.model.VoiceMail;
import com.example.demo.repository.VoiceMailRepository;

@Service
public class VoiceMailServiceImpl implements VoiceMailService {
	
	@Autowired
	private VoiceMailRepository voiceMailRepository;

	public List<VoiceMail> getAllVoiceMails() {

		List<VoiceMail> susbscribers = null;
		try {
			susbscribers = voiceMailRepository.findAll();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return susbscribers;
	}
	
public MessageResponse addNewVoiceMail(VoiceMaildto voiceMail) {
		
		VoiceMail VoiceMailNew=new VoiceMail();
		VoiceMailNew.setDateMessageReceived(voiceMail.getDateMessageReceived());
		VoiceMailNew.setMessageReadStatus(voiceMail.getMessageReadStatus());
		VoiceMailNew.setTimeMessageReceived(voiceMail.getTimeMessageReceived());
		VoiceMailNew.setVoiceMailFilePath(voiceMail.getVoiceMailFilePath());
		VoiceMailNew.setVoiceMailReceiverMSISDN(voiceMail.getVoiceMailReceiverMSISDN());
		VoiceMailNew.setVoiceMailSenderMSISDN(voiceMail.getVoiceMailSenderMSISDN());
		
		voiceMailRepository.save(VoiceMailNew);
		
		return new MessageResponse("VoiceMail Successfully registered!");
	}

public VoiceMail getVoiceMailById(Long id) {
	
	VoiceMail voiceMail = null;
	try {
		voiceMail = voiceMailRepository.findById(id).orElseThrow();
	} catch (Exception e) {
		e.printStackTrace();
	}

	return voiceMail;
}
}
