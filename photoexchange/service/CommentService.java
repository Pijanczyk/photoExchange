package com.photoexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photoexchange.dao.CommentDao;
import com.photoexchange.dao.PhotoDao;
import com.photoexchange.dao.UserDao;
import com.photoexchange.models.Comment;
import com.photoexchange.models.Photo;
import com.photoexchange.models.User;

@Service
public class CommentService {

	@Autowired
	private UserDao userDao;
	  
	@Autowired
	private PhotoDao photoDao;
	
	@Autowired
	private CommentDao commentDao;
	
	public void create(String text, String userId, String photoId) {
		User user = userDao.findOne(Long.parseLong(userId));
		Photo photo  = photoDao.findOne(Long.parseLong(photoId));
		Comment comment = new Comment(text, user, photo);
		commentDao.save(comment);
	}
	
}
