package com.datingapp.springbootdatingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datingapp.springbootdatingapp.dto.ConversationsDTO;
import com.datingapp.springbootdatingapp.dto.ResponseData;
import com.datingapp.springbootdatingapp.entity.ConversationsEntity;
import com.datingapp.springbootdatingapp.security.CustomUserBean;
import com.datingapp.springbootdatingapp.service.ConversationService;

@RestController
@RequestMapping("/convs")
@CrossOrigin
public class ConversationsController {
	
	@Autowired
	ConversationService convService;
	
	@PostMapping("/saveMessage")
	public ResponseData saveMessage(@RequestBody ConversationsEntity conversationEntity) {
		CustomUserBean loggedInUser = (CustomUserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		conversationEntity.setUsername(loggedInUser.getUsername());
		return convService.saveMessage(conversationEntity);
	}
	
	@PostMapping("/fetchMessages")
	public List<ConversationsEntity> fetchMessages(@RequestBody ConversationsEntity conversationentity) {
		return convService.fetchMessages(conversationentity);
	}
	
	@GetMapping("/fetchAllMessages")
	public List<ConversationsDTO> fetchAllMessages() {
		CustomUserBean loggedInUser = (CustomUserBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return convService.fetchAllMessages(loggedInUser.getUsername());
	}
}
