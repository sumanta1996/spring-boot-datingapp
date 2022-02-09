package com.datingapp.springbootdatingapp.dto;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class ConversationsDTO {
	
	private Object id;
	
	private Object conversationId;
	
	private Object username;
	
	private Object usernameSwiped;
	
	private Object message;
	
	private Object dateCreated;
	
	private Object lastUpdated;
	
	private Object firstName;
	
	private Object lastName;
	
	private Object age;
	
	private Object imageData;
	
	private Object matchedDate;

	public ConversationsDTO(Object id, Object conversationId, Object username, Object message, Object dateCreated, Object lastUpdated, Object usernameSwiped ,
			 Object matchedDate, Object firstName, Object lastName, Object age, Object imageData) {
		super();
		this.id = id;
		this.conversationId = conversationId;
		this.username = username;
		this.usernameSwiped = usernameSwiped;
		this.message = message;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.imageData = imageData;
		this.matchedDate = matchedDate;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Object getConversationId() {
		return conversationId;
	}

	public void setConversationId(Object conversationId) {
		this.conversationId = conversationId;
	}

	public Object getUsername() {
		return username;
	}

	public void setUsername(Object username) {
		this.username = username;
	}

	public Object getUsernameSwiped() {
		return usernameSwiped;
	}

	public void setUsernameSwiped(Object usernameSwiped) {
		this.usernameSwiped = usernameSwiped;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Object getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Object dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Object getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Object lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Object getFirstName() {
		return firstName;
	}

	public void setFirstName(Object firstName) {
		this.firstName = firstName;
	}

	public Object getLastName() {
		return lastName;
	}

	public void setLastName(Object lastName) {
		this.lastName = lastName;
	}

	public Object getAge() {
		return age;
	}

	public void setAge(Object age) {
		this.age = age;
	}

	public Object getImageData() {
		return imageData;
	}

	public void setImageData(Object imageData) {
		this.imageData = imageData;
	}

	public Object getMatchedDate() {
		return matchedDate;
	}

	public void setMatchedDate(Object matchedDate) {
		this.matchedDate = matchedDate;
	}
}
