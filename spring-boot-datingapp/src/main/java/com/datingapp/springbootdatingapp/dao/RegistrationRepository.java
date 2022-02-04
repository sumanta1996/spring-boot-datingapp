package com.datingapp.springbootdatingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datingapp.springbootdatingapp.entity.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
	
	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId, String password);
	
	public User findByUsername(String username);
	
	public boolean existsByUsername(String username);
	
	public boolean existsByEmailId(String emailId);
}
