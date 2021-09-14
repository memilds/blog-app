package com.blog.app.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.domains.CommentDomain;
import com.blog.app.entity.CommentEntity;
import com.blog.app.entity.PostEntity;
import com.blog.app.repo.CommentRepository;
import com.blog.app.repo.PostRepository;
import com.blog.app.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public CommentDomain add(CommentDomain domain) {

		PostEntity pentity = this.postRepository.getById(domain.getPostId());

		// mapper
		CommentEntity entity = new CommentEntity();
		entity.setPost(pentity);
		entity.setReview(domain.getReview());

		entity = this.commentRepository.save(entity);
		domain.setId(entity.getId());
		return domain;
	}

	@Override
	public List<CommentDomain> findAllByPostId(int postId) {
		// TODO Auto-generated method stub
		
		List<CommentEntity> list = this.commentRepository.fetchCommentsByPostId(postId);
		
		if(list.isEmpty()) {
			return Collections.emptyList();
		}
		
		return list.stream().map(c -> {
			CommentDomain domain = new CommentDomain();
			domain.setId(c.getId());
			domain.setReview(c.getReview());
			domain.setCreatedOn(c.getCreatedOn());
			domain.setUpdatedOn(c.getUpdatedOn());
			domain.setDeleted(c.isDeleted());
			domain.setDeletedOn(c.getDeletedOn());
			return domain;
		}).collect(Collectors.toList());
		
	}

	@Override
	public void delete(int id) {
		//TODO
		
	}

}
