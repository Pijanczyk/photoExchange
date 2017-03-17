package com.photoexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photoexchange.dao.PhotoDao;
import com.photoexchange.models.Photo;
import com.photoexchange.models.User;

@Service
public class PhotoServiceImpl {
	
	@Autowired
	private UserServiceImpl userService;
	  
	@Autowired
	private PhotoDao photoDao;

	public void create(Photo photo) {
		User creator = userService.getCurrentUser();
		photo.setCreator(creator);
		photoDao.save(photo);
	}
}
