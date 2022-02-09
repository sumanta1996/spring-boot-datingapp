package com.datingapp.springbootdatingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.datingapp.springbootdatingapp.entity.UserMatchedInfo;
import com.datingapp.springbootdatingapp.util.QueryConstants;

@CrossOrigin
public interface UserMatchedInfoRepository extends JpaRepository<UserMatchedInfo, Long> {
	
	public UserMatchedInfo findByUsernameAndUsernameSwiped(String username, String usernameSwiped);
	
	@Query(value = QueryConstants.fetchMatches, nativeQuery = true)
	public List<UserMatchedInfo> fetchLogginUserMatches(String username);
}
