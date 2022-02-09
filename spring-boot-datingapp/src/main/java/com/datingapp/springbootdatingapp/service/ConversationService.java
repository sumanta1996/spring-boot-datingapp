package com.datingapp.springbootdatingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datingapp.springbootdatingapp.dao.ConversationsRepository;
import com.datingapp.springbootdatingapp.dao.UserMatchedInfoRepository;
import com.datingapp.springbootdatingapp.daoImpl.UserOperationDaoImpl;
import com.datingapp.springbootdatingapp.dto.ConversationsDTO;
import com.datingapp.springbootdatingapp.dto.ResponseData;
import com.datingapp.springbootdatingapp.entity.ConversationsEntity;

@Service
public class ConversationService {
	
	@Autowired
	public UserMatchedInfoRepository userMatchedInfoRepo;
	
	@Autowired
	public ConversationsRepository conversationsRepo;
	
	@Autowired
	public UserMatchingService userMatchingService;
	
	@Autowired
	public UserOperationDaoImpl userOpDaoImpl;
	
	public ResponseData saveMessage(ConversationsEntity conversationEntity) {
		
		if(userMatchedInfoRepo.existsById(conversationEntity.getConversationId())) {
			conversationsRepo.save(conversationEntity);
			return new ResponseData(1, "Data updated successfully", null);
		}
		
		return new ResponseData(-1, "Failure", null);
	}
	
	public List<ConversationsEntity> fetchMessages(ConversationsEntity conversationEntity) {
		return conversationsRepo.findByConversationIdOrderByDateCreatedDesc(conversationEntity.getConversationId());
	}
	
	public List<ConversationsDTO> fetchAllMessages(String username) {
		return userOpDaoImpl.fetchAllUsersMessages(username);
	}
}
