package com.datingapp.springbootdatingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datingapp.springbootdatingapp.dao.RegistrationRepository;
import com.datingapp.springbootdatingapp.dto.AuthResponse;
import com.datingapp.springbootdatingapp.dto.ResponseData;
import com.datingapp.springbootdatingapp.entity.BasicUserDetails;
import com.datingapp.springbootdatingapp.entity.User;
import com.datingapp.springbootdatingapp.security.CustomUserBean;
import com.datingapp.springbootdatingapp.security.JwtTokenUtil;
import com.datingapp.springbootdatingapp.service.BasicUserDetailsService;
import com.datingapp.springbootdatingapp.service.UserImagesService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	RegistrationRepository regRepo;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	BasicUserDetailsService basicUserDetailsService;
	
	@Autowired
	UserImagesService userImagesService;

	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody User userRequest) {
		if(regRepo.existsByUsername(userRequest.getUsername())){
			return ResponseEntity.badRequest().body(new ResponseData(-1, "Username is already taken", null));
		}
		if(regRepo.existsByEmailId(userRequest.getEmailId())){
			return ResponseEntity.badRequest().body(new ResponseData(-1, "Email is already taken", null));
		}

		userRequest.setPassword(encoder.encode(userRequest.getPassword()));
		regRepo.save(userRequest);
		return ResponseEntity.ok(new ResponseData(1,"User signed up successfully", null));
	}

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody User userRequest) {
		//System.out.println("AuthController -- userLogin");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenUtil.generateJwtToken(authentication);
		CustomUserBean userBean = (CustomUserBean) authentication.getPrincipal();    
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setToken(token);
		authResponse.setBasicUserDetails(basicUserDetailsService.findByUsername(userRequest.getUsername()));
		authResponse.setImageData(userImagesService.fetchFirstImage(userRequest.getUsername()).getImageData());
		
		return ResponseEntity.ok(authResponse);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		
		return ResponseEntity.ok(new ResponseData(2,"User logged out successfully", null));
	}
}
