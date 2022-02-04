package com.datingapp.springbootdatingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.datingapp.springbootdatingapp.entity.UserMatchedInfo;
import com.datingapp.springbootdatingapp.entity.UserMatchingIdentity;

@CrossOrigin
public interface UserMatchedInfoRepository extends JpaRepository<UserMatchedInfo, UserMatchingIdentity> {
	
	public UserMatchedInfo findByUsernameAndUsernameSwiped(String username, String usernameSwiped);
}
