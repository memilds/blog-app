package com.blog.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blog.app.entity.LikeUnLikeEntity;

@Repository
public interface LikeUnlikeRepository extends CrudRepository<LikeUnLikeEntity, Integer> {

}
