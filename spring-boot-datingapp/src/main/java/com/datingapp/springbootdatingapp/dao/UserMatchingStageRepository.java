package com.datingapp.springbootdatingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.datingapp.springbootdatingapp.entity.UserMatchingIdentity;
import com.datingapp.springbootdatingapp.entity.UserMatchingStage;

@CrossOrigin
public interface UserMatchingStageRepository extends JpaRepository<UserMatchingStage, UserMatchingIdentity>  {
	
	public List<UserMatchingStage> findByUsername(String username);
	
	public List<UserMatchingStage> findByUsernameSwiped(String username);
	
	public UserMatchingStage findByUsernameAndUsernameSwiped(String username, String usernameSwiped);
}
