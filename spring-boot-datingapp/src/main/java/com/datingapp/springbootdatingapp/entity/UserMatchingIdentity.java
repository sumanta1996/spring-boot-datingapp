package com.datingapp.springbootdatingapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class UserMatchingIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String usernameSwiped;
	
	public UserMatchingIdentity() {}

	public UserMatchingIdentity(String username, String usernameSwiped) {
		super();
		this.username = username;
		this.usernameSwiped = usernameSwiped;
	}

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
