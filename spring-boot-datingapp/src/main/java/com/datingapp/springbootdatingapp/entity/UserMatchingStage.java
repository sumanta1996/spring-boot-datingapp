package com.datingapp.springbootdatingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "user_matching_stage")
@IdClass(UserMatchingIdentity.class)
public class UserMatchingStage {
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Id
	@Column(name = "username_swiped")
	private String usernameSwiped; 
	
	public UserMatchingStage() {}

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
}
