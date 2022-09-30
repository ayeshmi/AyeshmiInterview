package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(	name = "subscriber", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "subscriberMSISDN"),
			@UniqueConstraint(columnNames = "email") 
		})
public class Subscriber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subscriberID;
	
	@NotBlank
	@Size(max = 15)
	private String subscriberMSISDN;
	
	@NotBlank
	@Size(max = 15)
	private String subscriberPIN;
	
	@NotBlank
	@Size(max = 50)
	private String firstName;
	
	@NotBlank
	@Size(max = 50)
	private String lastName;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 10)
	private String voiceMailAccountStatus;
	
	@JsonBackReference
	@OneToMany(mappedBy = "subscriber", cascade = {CascadeType.PERSIST, CascadeType.MERGE
            , CascadeType.DETACH, CascadeType.REFRESH})
	 private List<VoiceMail> voiceMails;
	

	public Subscriber() {
		
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
