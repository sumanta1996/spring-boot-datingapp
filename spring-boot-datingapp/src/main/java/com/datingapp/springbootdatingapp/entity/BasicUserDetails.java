package com.datingapp.springbootdatingapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "basic_user_details")
public class BasicUserDetails {	
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private char gender;
	
	@Column(name = "self_summary")
	private String selfSummary;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "living_in")
	private String livingIn;
	
	@OneToOne
    @JoinColumn(name = "username")
	@JsonIgnore	//Adding this because bidirectional mapping is cause stack overflow error. So adding @JsonIgnore to ignore this datatype
	private User user;
	
	public BasicUserDetails() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSelfSummary() {
		return selfSummary;
	}

	public void setSelfSummary(String selfSummary) {
		this.selfSummary = selfSummary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getLivingIn() {
		return livingIn;
	}

	public void setLivingIn(String livingIn) {
		this.livingIn = livingIn;
	}
}
