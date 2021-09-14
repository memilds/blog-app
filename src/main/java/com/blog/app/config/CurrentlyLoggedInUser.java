package com.blog.app.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentlyLoggedInUser extends User {

	private int userId;
	
	public CurrentlyLoggedInUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			int userId
			) {
		super(username, password, authorities);
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}
	
	

}
