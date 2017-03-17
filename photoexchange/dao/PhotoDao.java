package com.photoexchange.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.photoexchange.models.Photo;

/**
 *
 * @author Filip
 */
@Transactional
public interface PhotoDao extends CrudRepository<Photo, Long> {



}
