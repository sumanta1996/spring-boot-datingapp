package com.datingapp.springbootdatingapp.dao;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.datingapp.springbootdatingapp.entity.BasicUserDetails;
import com.datingapp.springbootdatingapp.util.QueryConstants;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@RepositoryRestResource(collectionResourceRel = "basicUserDetail", path = "basicUserDetails")
@CrossOrigin
public interface BasicUserDetailsRepository extends JpaRepository<BasicUserDetails, String> {
	
	Page<BasicUserDetails> findByGender(@RequestParam("gender") Character gender, Pageable pageable);
	
	BasicUserDetails findByUsername(@RequestParam("username") String userId);
	
	@Query(value = QueryConstants.findAllUsersToMatch, nativeQuery = true)
	List<BasicUserDetails> findAllUsersToMatch(String username);
}
