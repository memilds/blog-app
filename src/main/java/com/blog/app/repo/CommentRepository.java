package com.blog.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.app.entity.CommentEntity;
import com.blog.app.entity.PostEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

	// native, hql
	@Query(value = "SELECT * FROM tbl_comments where fk_post_id = ?1 and is_deleted = false", nativeQuery = true)
	List<CommentEntity> fetchCommentsByPostId(int postId);
}
