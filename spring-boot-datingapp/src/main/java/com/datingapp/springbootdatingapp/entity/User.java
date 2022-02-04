package com.datingapp.springbootdatingapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Column(name = "email_id")
	private String emailId;
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private BasicUserDetails basicUserDetails;
	
	public User() {}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BasicUserDetails getBasicUserDetails() {
		return basicUserDetails;
	}

	public void setBasicUserDetails(BasicUserDetails basicUserDetails) {
		this.basicUserDetails = basicUserDetails;
	}
}
