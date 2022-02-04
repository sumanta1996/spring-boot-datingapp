package com.datingapp.springbootdatingapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datingapp.springbootdatingapp.dao.BasicUserDetailsRepository;
import com.datingapp.springbootdatingapp.entity.BasicUserDetails;

@Service
public class BasicUserDetailsService {

	@Autowired
	BasicUserDetailsRepository basicUserDetailsRepo;
	
	@Autowired
	UserImagesService userImagesService;
	
	public BasicUserDetails findByUsername(String username) {
		BasicUserDetails tempObj = basicUserDetailsRepo.findByUsername(username);
		//tempObj.setUser(null);
		return tempObj;
	}
	
	public List<BasicUserDetails> findAllUsersForMatching(String username) {
		
		return basicUserDetailsRepo.findAllUsersToMatch(username);
	}
	
	public Map<String, Object> fetchBasicUserDetailsAlongWithImage(String username) {
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("basicUserDetails", basicUserDetailsRepo.findByUsername(username));
		response.put("imageData", userImagesService.fetchFirstImage(username).getImageData());
		
		return response;
	}
}
