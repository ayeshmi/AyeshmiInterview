package com.example.demo.dto;

import com.example.demo.model.Subscriber;

public class VoiceMaildto {

	private Long voiceMailID;

	private String voiceMailSenderMSISDN;

	private String voiceMailReceiverMSISDN;

	private String dateMessageReceived;

	private String timeMessageReceived;

	private String messageReadStatus;

	private String voiceMailFilePath;

    private Subscriber subscriber;
	
	

	public VoiceMaildto() {
		
	}

	public Long getVoiceMailID() {
		return voiceMailID;
	}

	public void setVoiceMailID(Long voiceMailID) {
		this.voiceMailID = voiceMailID;
	}

	public String getVoiceMailSenderMSISDN() {
		return voiceMailSenderMSISDN;
	}

	public void setVoiceMailSenderMSISDN(String voiceMailSenderMSISDN) {
		this.voiceMailSenderMSISDN = voiceMailSenderMSISDN;
	}

	public String getVoiceMailReceiverMSISDN() {
		return voiceMailReceiverMSISDN;
	}

	public void setVoiceMailReceiverMSISDN(String voiceMailReceiverMSISDN) {
		this.voiceMailReceiverMSISDN = voiceMailReceiverMSISDN;
	}

	public String getDateMessageReceived() {
		return dateMessageReceived;
	}

	public void setDateMessageReceived(String dateMessageReceived) {
		this.dateMessageReceived = dateMessageReceived;
	}

	public String getTimeMessageReceived() {
		return timeMessageReceived;
	}

	public void setTimeMessageReceived(String timeMessageReceived) {
		this.timeMessageReceived = timeMessageReceived;
	}

	public String getMessageReadStatus() {
		return messageReadStatus;
	}

	public void setMessageReadStatus(String messageReadStatus) {
		this.messageReadStatus = messageReadStatus;
	}

	public String getVoiceMailFilePath() {
		return voiceMailFilePath;
	}

	public void setVoiceMailFilePath(String voiceMailFilePath) {
		this.voiceMailFilePath = voiceMailFilePath;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
}
