package com.datingapp.springbootdatingapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "user_matched_info")
@IdClass(UserMatchingIdentity.class)
public class UserMatchedInfo {
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Id
	@Column(name = "username_swiped")
	private String usernameSwiped;
	
	@Column(name = "date_created")
	@CreationTimestamp
	private Date dateCreated;
	
	public UserMatchedInfo() {}
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUsernameSwiped() {
		return usernameSwiped;
	}



	public void setUsernameSwiped(String usernameSwiped) {
		this.usernameSwiped = usernameSwiped;
	}



	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
