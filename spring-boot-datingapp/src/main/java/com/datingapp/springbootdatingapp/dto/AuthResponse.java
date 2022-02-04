package com.datingapp.springbootdatingapp.dto;

import com.datingapp.springbootdatingapp.entity.BasicUserDetails;

public class AuthResponse {
	private String token;
	private BasicUserDetails basicUserDetails;
	//private byte[] imageData;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public BasicUserDetails getBasicUserDetails() {
		return basicUserDetails;
	}

	public void setBasicUserDetails(BasicUserDetails basicUserDetails) {
		this.basicUserDetails = basicUserDetails;
	}

	/*public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}*/
}
