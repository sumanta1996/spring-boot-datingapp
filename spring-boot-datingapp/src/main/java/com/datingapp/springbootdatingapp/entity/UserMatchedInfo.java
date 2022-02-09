package com.datingapp.springbootdatingapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "user_matched_info")
//@IdClass(UserMatchingIdentity.class)
public class UserMatchedInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//@Id
	@Column(name = "username")
	private String username;
	
	//@Id
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
}
