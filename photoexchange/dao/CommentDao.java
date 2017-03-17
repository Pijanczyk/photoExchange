package com.photoexchange.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.photoexchange.models.Comment;

/**
 *
 * @author Filip
 */
@Transactional
public interface CommentDao extends CrudRepository<Comment, Long> {
	


}
