package com.datingapp.springbootdatingapp.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.datingapp.springbootdatingapp.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/* This is the user bean which helps in authentication from Spring end.
 * */
public class CustomUserBean implements UserDetails {
	private static final long serialVersionUID = -4709084843450077569L;
	
	private String userName;
	
	private String email;
	
	@JsonIgnore
	private String password;
	
	public CustomUserBean(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	public static CustomUserBean createInstance(User user) {
		
		return new CustomUserBean(user.getUsername(), user.getEmailId(), user.getPassword());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	public String getEmail() {
	    return email;
	  }

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
