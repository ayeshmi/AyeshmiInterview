package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.VoiceMaildto;
import com.example.demo.model.VoiceMail;

public interface VoiceMailService {
	
	public List<VoiceMail> getAllVoiceMails();
	public MessageResponse addNewVoiceMail(VoiceMaildto voiceMail);
	public VoiceMail getVoiceMailById(Long id);

}
