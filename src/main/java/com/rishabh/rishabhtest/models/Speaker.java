package com.rishabh.rishabhtest.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="speakers")
public class Speaker {
	
	private Integer speakerId;
	private String firstName;
	private String lastName;
	private String title;
	private String company;
	private String speakerBio;
	private byte[] speakerPhoto;
	
	private List<Session> sessions;
	
	public Speaker() {
		System.out.println("Speaker: Default Constructor called");
	}
	
	@Id
	@Column(name="speaker_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSpeakerId() {
		System.out.println("Session: getSpeakerId called");
		return speakerId;
	}
	public void setSpeakerId(Integer speakerId) {
		System.out.println("Session: setSpeakerId called");
		this.speakerId = speakerId;
	}
	
	@Column(name="first_name")
	public String getFirstName() {
		System.out.println("Session: getFirstName called");
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("Session: setFirstName called");
		this.firstName = firstName;
	}
	
	@Column(name="last_name")
	public String getLastName() {
		System.out.println("Session: getLastName called");
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("Session: setLastName called");
		this.lastName = lastName;
	}
	
	@Column(name="title")
	public String getTitle() {
		System.out.println("Session: getTitle called");
		return title;
	}
	public void setTitle(String title) {
		System.out.println("Session: setTitle called");
		this.title = title;
	}
	
	@Column(name="company")
	public String getCompany() {
		System.out.println("Session: getCompany called");
		return company;
	}
	public void setCompany(String company) {
		System.out.println("Session: setCompany called");
		this.company = company;
	}
	
	@Column(name="speaker_bio")
	public String getSpeakerBio() {
		System.out.println("Session: getSpeakerBio called");
		return speakerBio;
	}
	public void setSpeakerBio(String speakerBio) {
		System.out.println("Session: setSpeakerBio called");
		this.speakerBio = speakerBio;
	}

	@ManyToMany(mappedBy= "speakers")
	@JsonIgnore
	public List<Session> getSessions() {
		System.out.println("Session: getSessions called");
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		System.out.println("Session: setSessions called");
		this.sessions = sessions;
	}

	@Lob // large object
	@Type(type="org.hibernate.type.BinaryType") // define the type of data 
	public byte[] getSpeakerPhoto() {
		return speakerPhoto;
	}

	public void setSpeakerPhoto(byte[] speakerPhoto) {
		this.speakerPhoto = speakerPhoto;
	}
	
}
