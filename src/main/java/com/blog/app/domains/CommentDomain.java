package com.blog.app.domains;

import javax.validation.constraints.NotBlank;

public class CommentDomain extends AbstractDomain {

	@NotBlank(message = "Comment cannot be empty")
	private String review;
	private int userId;
	private String userName;
	private String userEmail;
	private int postId;

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

}
