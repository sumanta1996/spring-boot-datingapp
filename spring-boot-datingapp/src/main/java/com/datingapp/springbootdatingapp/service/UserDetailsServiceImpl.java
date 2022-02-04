package com.datingapp.springbootdatingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.datingapp.springbootdatingapp.dao.RegistrationRepository;
import com.datingapp.springbootdatingapp.entity.User;
import com.datingapp.springbootdatingapp.security.CustomUserBean;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	RegistrationRepository regRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = regRepo.findByUsername(username);
		
		if(null == user) {
			throw new UsernameNotFoundException("User with user name "+ username + " not found");
		}
		
		return CustomUserBean.createInstance(user);
	}

}
