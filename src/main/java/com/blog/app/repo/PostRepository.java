package com.blog.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.app.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>{
	
	@Query(value = "select * from tbl_posts where is_deleted=false", nativeQuery = true)
	List<PostEntity> findAllPosts();
}
