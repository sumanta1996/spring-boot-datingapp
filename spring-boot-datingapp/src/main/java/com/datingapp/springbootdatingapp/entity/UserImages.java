package com.datingapp.springbootdatingapp.entity;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_images")
public class UserImages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Lob
	@Column(name = "image_data")
	private byte[] imageData;
	
	@Column(name = "ordering")
	private int ordering;
	
	@Column(name = "date_created")
	@CreationTimestamp
	private Date dateCreated;
	
	@Column(name = "last_updated")
	@UpdateTimestamp	//update timestamp when update occurs
	private Date lastUpdated;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username", insertable = false, updatable = false)
	@JsonIgnore
    private BasicUserDetails basicUserDetails;
	
	public UserImages() {}

	public UserImages(String username, byte[] imageData, int ordering) {
		super();
		this.username = username;
		this.imageData = imageData;
		this.ordering = ordering;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int ordering) {
		this.ordering = ordering;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "UserImages [id=" + id + ", username=" + username + ", imageData=" + imageData
				+ ", order=" + ordering + ", dateCreated=" + dateCreated + "]";
	}

	public BasicUserDetails getBasicUserDetails() {
		return basicUserDetails;
	}

	public void setBasicUserDetails(BasicUserDetails basicUserDetails) {
		this.basicUserDetails = basicUserDetails;
	}
	
}
