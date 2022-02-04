package com.datingapp.springbootdatingapp.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datingapp.springbootdatingapp.dao.UserImagesRepository;
import com.datingapp.springbootdatingapp.dto.ResponseData;
import com.datingapp.springbootdatingapp.dto.UserImageOrder;
import com.datingapp.springbootdatingapp.entity.UserImages;
import com.datingapp.springbootdatingapp.util.Utilities;

@Service
public class UserImagesService {
	
	@Autowired
	UserImagesRepository userImagesRepo;
	
	public ResponseData uploadImages(int id, byte[] imageData, String username) {
		
		//If not null then upload
		if(null != imageData) {
			if(id > 0) {
				//It's edit
				Optional<UserImages> userImageOptional = userImagesRepo.findById(Long.valueOf(id));
				if(userImageOptional.isEmpty()) {
					return new ResponseData(-1, "Please send valid data to replace existing images.", null);
				}
				
				UserImages userImagesObj = userImageOptional.get();
				userImagesObj.setImageData(imageData);
				userImagesRepo.save(userImagesObj);
				return new ResponseData(1, "Data updated successfully.", null);
			}
			
			//Find total images for logged in user
			int count = userImagesRepo.countOfImagesEachUser(username);
			
			if(count<6) {
				//Add the new image to database by compressing
				UserImages userImageObj = new UserImages(username, imageData, count+1);
				userImagesRepo.save(userImageObj);
				return new ResponseData(1, "Data updated successfully.", null);
			}
		}
		
		return new ResponseData(-1, "Failed.", null);
	}
	
	@Transactional
	public ResponseData setImageOrdering(List<UserImageOrder> userImageOrdering) {
		//If ordering is changed this will not be null
		if(null != userImageOrdering && userImageOrdering.size()>0) {
			
			int rowsUpdated = 0;
			for(int i=0;i<userImageOrdering.size();i++) {
				rowsUpdated += userImagesRepo.updateOrderingForImages(userImageOrdering.get(i).order, userImageOrdering.get(i).id);
			}
			
			if(rowsUpdated == userImageOrdering.size()) {
				return new ResponseData(1, "Data updated successfully.", null);
			}
		}
		
		return new ResponseData(-1, "Ordering failed to update.", null);
	}
	
	public UserImages fetchFirstImage(String username) {
		return userImagesRepo.fetchFirstImage(username);
	}
	
}
