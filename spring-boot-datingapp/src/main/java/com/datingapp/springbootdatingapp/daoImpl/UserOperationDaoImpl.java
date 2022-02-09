package com.datingapp.springbootdatingapp.daoImpl;

import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datingapp.springbootdatingapp.dto.ConversationsDTO;
import com.datingapp.springbootdatingapp.util.QueryConstants;

@Repository
public class UserOperationDaoImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<ConversationsDTO> fetchAllUsersMessages(String username) {
		Session session = sessionFactory.openSession();;
		try {
			Query<Object[]> query = session.createNativeQuery(QueryConstants.fetchAllMessages);
			query.setParameter("username", username);
			List<Object[]> results = query.getResultList();
			List<ConversationsDTO> actualRes = new ArrayList<ConversationsDTO>();
			for(int i=0;i<results.size();i++) {
				Object[] temp = results.get(i);
				actualRes.add(new ConversationsDTO(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11]));
			}
			
			return actualRes;
		}finally {
			if(null != session) {
				session.close();
			}
		}
	}
}
