package com.blog.app.service;

import java.util.List;

import com.blog.app.domains.PostDomain;

public interface PostService {
	PostDomain add(PostDomain domain);
	void update(PostDomain domain);
	PostDomain getById(int id);
	List<PostDomain> findAll();
	void delete(int id);
}
