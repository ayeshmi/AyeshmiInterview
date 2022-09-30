package com.example.demo.dto;

import java.util.List;


import com.example.demo.model.VoiceMail;


public class Subscriberdto {

	private Long subscriberID;

	private String subscriberMSISDN;

	private String subscriberPIN;

	private String firstName;

	private String lastName;

	private String email;

	private String voiceMailAccountStatus;

	 private List<VoiceMail> voiceMails;
	

	public Subscriberdto() {
		
	}

	public Long getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(Long subscriberID) {
		this.subscriberID = subscriberID;
	}

	public String getSubscriberMSISDN() {
		return subscriberMSISDN;
	}

	public void setSubscriberMSISDN(String subscriberMSISDN) {
		this.subscriberMSISDN = subscriberMSISDN;
	}

	public String getSubscriberPIN() {
		return subscriberPIN;
	}

	public void setSubscriberPIN(String subscriberPIN) {
		this.subscriberPIN = subscriberPIN;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVoiceMailAccountStatus() {
		return voiceMailAccountStatus;
	}

	public void setVoiceMailAccountStatus(String voiceMailAccountStatus) {
		this.voiceMailAccountStatus = voiceMailAccountStatus;
	}

	public List<VoiceMail> getVoiceMails() {
		return voiceMails;
	}

	public void setVoiceMails(List<VoiceMail> voiceMails) {
		this.voiceMails = voiceMails;
	}
}
