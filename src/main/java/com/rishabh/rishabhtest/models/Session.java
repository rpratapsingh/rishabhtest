package com.rishabh.rishabhtest.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Session {

	private Long sessionId;
	private String sessionName;
	private String sessionDescription;
	private Integer sessionLength;

	private List<Speaker> speakers;

	public Session() {
		System.out.println("Session: Default Constructor called");
	}

	@Id
	@Column(name = "session_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getSessionId() {
		System.out.println("Session: getSessionId called");
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		System.out.println("Session: setSessionId called");
		this.sessionId = sessionId;
	}

	@Column(name = "session_name")
	public String getSessionName() {
		System.out.println("Session: getSessionName called");
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		System.out.println("Session: setSessionName called");
		this.sessionName = sessionName;
	}

	@Column(name = "session_description")
	public String getSessionDescription() {
		System.out.println("Session: getSessionDescription called");
		return sessionDescription;
	}

	public void setSessionDescription(String sessionDescription) {
		System.out.println("Session: setSessionDescription called");
		this.sessionDescription = sessionDescription;
	}

	@Column(name = "session_length")
	public Integer getSessionLength() {
		System.out.println("Session: getSessionLength called");
		return sessionLength;
	}

	public void setSessionLength(Integer sessionLength) {
		System.out.println("Session: setSessionLength called");
		this.sessionLength = sessionLength;
	}

	@ManyToMany
	@JoinTable(
			name = "session_speakers", 
			joinColumns = @JoinColumn(name = "session_id"), 
			inverseJoinColumns = @JoinColumn(name = "speaker_id"))
	public List<Speaker> getSpeakers() {
		System.out.println("Session: getSpeakers called");
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		System.out.println("Session: setSpeakers called");
		this.speakers = speakers;
	}

}
