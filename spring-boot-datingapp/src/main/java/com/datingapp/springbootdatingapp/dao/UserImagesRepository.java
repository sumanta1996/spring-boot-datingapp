package com.datingapp.springbootdatingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.datingapp.springbootdatingapp.entity.UserImages;
import com.datingapp.springbootdatingapp.util.QueryConstants;

@RepositoryRestResource(collectionResourceRel = "userImages", path = "userImages")
@CrossOrigin
public interface UserImagesRepository extends JpaRepository<UserImages, Long> {
	
	@Query(value = QueryConstants.updateImageOrdering, nativeQuery = true)
	@Modifying
	public int updateOrderingForImages(int order, int id);
	
	@Query(value = QueryConstants.countImagesUserWise, nativeQuery = true)
	public int countOfImagesEachUser(String username);
	
	public List<UserImages> findByUsernameOrderByOrderingAsc(String username);
	
	@Query(value = QueryConstants.fetchFirstImage, nativeQuery = true)
	public UserImages fetchFirstImage(String username);
}
