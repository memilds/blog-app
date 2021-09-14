package com.blog.app.domains;

import javax.validation.constraints.NotBlank;

public class PostDomain extends AbstractDomain{
	
	@NotBlank(message = "Title cannot be empty")
	private String title;
	
	@NotBlank(message = "Description cannot be empty")
	private String description;
	
	private int userId;
	
	private String email;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
