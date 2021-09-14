package com.blog.app.service;

import java.util.List;

import com.blog.app.domains.CommentDomain;

public interface CommentService {
	
	CommentDomain add(CommentDomain domain);
	List<CommentDomain> findAllByPostId(int postId);
	void delete(int id);
}
