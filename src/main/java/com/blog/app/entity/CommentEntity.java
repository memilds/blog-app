package com.blog.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_comments")
public class CommentEntity extends AbstractEntity {

	@Column(name = "review")
	@Lob
	private String review;

	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "fk_post_id")
	private PostEntity post;
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}
	
	// One to One, One to Many, Many to One, Many to Many
	
}
