package com.blog.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_like_unlike")
public class LikeUnLikeEntity extends AbstractEntity{
	
	@Column(name="fk_post_id")
	private int postId;
	
	@Column(name="fk_user_id")
	private int userId;
	
	@Column(name="like_unlike")
	private int likeUnlike;
	
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLikeUnlike() {
		return likeUnlike;
	}
	public void setLikeUnlike(int likeUnlike) {
		this.likeUnlike = likeUnlike;
	}
	
	
	

}
