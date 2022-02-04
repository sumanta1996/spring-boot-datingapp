package com.datingapp.springbootdatingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datingapp.springbootdatingapp.dao.BasicUserDetailsRepository;
import com.datingapp.springbootdatingapp.dao.RegistrationRepository;
import com.datingapp.springbootdatingapp.dao.UserMatchedInfoRepository;
import com.datingapp.springbootdatingapp.dao.UserMatchingStageRepository;
import com.datingapp.springbootdatingapp.dto.ResponseData;
import com.datingapp.springbootdatingapp.entity.BasicUserDetails;
import com.datingapp.springbootdatingapp.entity.UserMatchedInfo;
import com.datingapp.springbootdatingapp.entity.UserMatchingStage;
import com.datingapp.springbootdatingapp.util.Utilities;

@Service
public class UserMatchingService {
	
	@Autowired
	UserMatchingStageRepository userMatchingStageRepo;
	
	@Autowired
	UserMatchedInfoRepository userMatchedInfoRepo;
	
	@Autowired
	RegistrationRepository regRepo;
	
	@Autowired
	BasicUserDetailsRepository basicUserDetailsRepo;
	
	public ResponseData swipeRight(UserMatchingStage userMatchingStage) {
		
		//Validations
		if(Utilities.checkNullAndEmpty(userMatchingStage.getUsername()) ||
				Utilities.checkNullAndEmpty(userMatchingStage.getUsernameSwiped()) ||
				userMatchingStage.getUsername().equalsIgnoreCase(userMatchingStage.getUsernameSwiped()) ||
				//Check usernameSwiped user exist or not
				null == regRepo.findByUsername(userMatchingStage.getUsernameSwiped())) {
			return new ResponseData(-2, "Request data is not proper.", null);
		}
		
		if(null != userMatchedInfoRepo.findByUsernameAndUsernameSwiped(userMatchingStage.getUsernameSwiped(), userMatchingStage.getUsername())
				|| null != userMatchedInfoRepo.findByUsernameAndUsernameSwiped(userMatchingStage.getUsername(), userMatchingStage.getUsernameSwiped())) {
			//Already they are matched
			return new ResponseData(-2, "Users are already matched.", null);
		}
		
		//Check whether opposite side swipe exist or not -- If it does then match
		/* So what we trying to do here is whatever username and username swiped coming
		 * just reverse them and check whether that exist or not because if it does opposite
		 * person has also swiped. Therefore it's a match.
		 * */
		UserMatchingStage matchingObj = userMatchingStageRepo.findByUsernameAndUsernameSwiped(
				userMatchingStage.getUsernameSwiped(), userMatchingStage.getUsername());
		
		//If doesn't just add the entry
		if(null == matchingObj) {
			userMatchingStageRepo.save(userMatchingStage);
			return new ResponseData(2, "Data saved successfully.", null);
		}else {
			//It's a match
			
			//Delete from staging table
			userMatchingStageRepo.delete(matchingObj);
			
			//Entry in matched table
			UserMatchedInfo userMatchedObj = new UserMatchedInfo();
			userMatchedObj.setUsername(userMatchingStage.getUsername());
			userMatchedObj.setUsernameSwiped(userMatchingStage.getUsernameSwiped());
			
			userMatchedInfoRepo.save(userMatchedObj);
			
			BasicUserDetails userDetailsMatched = basicUserDetailsRepo.findByUsername(userMatchingStage.getUsernameSwiped());
			
			return new ResponseData(3, "It's a Match.", userDetailsMatched);
		}
	}
	
	public List<BasicUserDetails> fetchAllMatches(String username) {
		//This will fetch all the users with whom logged in user have match with
		List<String> usersList = userMatchedInfoRepo.fetchLogginUserMatches(username);
		
		return basicUserDetailsRepo.findAllById(usersList);
	}
}
