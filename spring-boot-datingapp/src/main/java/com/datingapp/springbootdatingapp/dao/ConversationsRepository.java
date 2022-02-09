package com.datingapp.springbootdatingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.datingapp.springbootdatingapp.dto.ConversationsDTO;
import com.datingapp.springbootdatingapp.entity.ConversationsEntity;
import com.datingapp.springbootdatingapp.util.QueryConstants;

@CrossOrigin
public interface ConversationsRepository extends JpaRepository<ConversationsEntity, Long>  {
	public List<ConversationsEntity> findByConversationIdOrderByDateCreatedDesc(Long convId);
}
