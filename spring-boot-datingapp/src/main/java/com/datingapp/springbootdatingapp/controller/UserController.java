package com.datingapp.springbootdatingapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.datingapp.springbootdatingapp.dto.ResponseData;
import com.datingapp.springbootdatingapp.dto.UserImageOrder;
import com.datingapp.springbootdatingapp.entity.BasicUserDetails;
import com.datingapp.springbootdatingapp.entity.UserImages;
import com.datingapp.springbootdatingapp.entity.UserMatchingIdentity;
import com.datingapp.springbootdatingapp.entity.UserMatchingStage;
import com.datingapp.springbootdatingapp.security.CustomUserBean;
import com.datingapp.springbootdatingapp.service.BasicUserDetailsService;
import com.datingapp.springbootdatingapp.service.UserImagesService;
import com.datingapp.springbootdatingapp.service.UserMatchingService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserMatchingService userMatchingService;
	
	@Autowired
	BasicUserDetailsService basicUserDetailsService;
	
	@Autowired
	UserImagesService userImagesService;
	
	@PostMapping("/swipeRight")
	public ResponseData swipeRight(@RequestBody UserMatchingStage userMatchingStage) {
		
		CustomUserBean loggedInUser = (CustomUserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userMatchingStage.setUsername(loggedInUser.getUsername());
		
		return userMatchingService.swipeRight(userMatchingStage);
	}
	
	@GetMapping("/findAll")
	public ResponseData findAllForMatches() {
		CustomUserBean loggedInUser = (CustomUserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return new ResponseData(0, "Success", basicUserDetailsService.findAllUsersForMatching(loggedInUser.getUsername()));
	}
	
	@RequestMapping(path = "/uploadImages", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseData uploadImages(@RequestPart int id, @RequestPart MultipartFile doc) {
		CustomUserBean loggedInUser = (CustomUserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			return userImagesService.uploadImages(id, doc.getBytes(), loggedInUser.getUsername());
		} catch (IOException e) {
			System.out.println("Error: "+e);
			return new ResponseData(-1, "Failure", null);
		}
	}
	
	@PostMapping("/setImageOrdering")
	public ResponseData setImageOrdering(@RequestBody List<UserImageOrder> userImageOrders) {
		
		return userImagesService.setImageOrdering(userImageOrders);
	}
	
	@GetMapping("/fetchBasicUserDetails")
	public Map<String, Object> fetchBasicUserDetailsAlongWithImage() {
		CustomUserBean loggedInUser = (CustomUserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return basicUserDetailsService.fetchBasicUserDetailsAlongWithImage(loggedInUser.getUsername());
	}
	
	@GetMapping("/fetchAllMatches")
	public List<BasicUserDetails> fetchAllMatches() {
		CustomUserBean loggedInUser = (CustomUserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userMatchingService.fetchAllMatches(loggedInUser.getUsername());
	}
}
