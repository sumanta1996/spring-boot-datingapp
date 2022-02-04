package com.datingapp.springbootdatingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datingapp.springbootdatingapp.dao.BasicUserDetailsRepository;
import com.datingapp.springbootdatingapp.dao.RegistrationRepository;
import com.datingapp.springbootdatingapp.entity.BasicUserDetails;
import com.datingapp.springbootdatingapp.entity.User;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository regRepo;
	
	@Transactional
	public User saveUser(User user) {
		
		return regRepo.save(user);
		
	}
	
	public User fetchUserByEmailId(String emailId) {
		return regRepo.findByEmailId(emailId);
	}
	
	public User fetchUserByEmailIdAndPassword(String emailId, String password) {
		return regRepo.findByEmailIdAndPassword(emailId, password);
	}
}
