package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "voicemail")
public class VoiceMail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long voiceMailID;
	
	@NotBlank
	@Size(max = 15)
	private String voiceMailSenderMSISDN;
	
	@NotBlank
	@Size(max = 15)
	private String voiceMailReceiverMSISDN;
	
	@NotBlank
	@Size(max = 18)
	private String dateMessageReceived;
	
	@NotBlank
	@Size(max = 15)
	private String timeMessageReceived;
	
	@NotBlank
	@Size(max = 15)
	private String messageReadStatus;
	
	@NotBlank
	@Size(max = 200)
	private String voiceMailFilePath;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE
            , CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "subscriber_ids")
    private Subscriber subscriber;
	
	

	public VoiceMail() {
		super();
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
