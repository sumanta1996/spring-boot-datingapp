package com.datingapp.springbootdatingapp.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "conversations")
public class ConversationsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;
	
	@Column(name = "conversation_id")
	public Long conversationId;
	
	@Column(name = "username")
	public String username;
	
	@Column(name = "message")
	public String message;
	
	@Column(name = "date_created")
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@Column(name = "last_updated")
	@UpdateTimestamp	//update timestamp when update occurs
	private Timestamp lastUpdated;
	
	@Transient
	private BasicUserDetails basicUserDetails;
	
	public ConversationsEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConversationId() {
		return conversationId;
	}

	public void setConversationId(Long conversationId) {
		this.conversationId = conversationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public BasicUserDetails getBasicUserDetails() {
		return basicUserDetails;
	}

	public void setBasicUserDetails(BasicUserDetails basicUserDetails) {
		this.basicUserDetails = basicUserDetails;
	}
}
