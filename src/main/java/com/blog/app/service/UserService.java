package com.blog.app.service;

import com.blog.app.domains.UserDomain;

public interface UserService {
	UserDomain add(UserDomain domain);
	UserDomain getByEmail(String email);
}
