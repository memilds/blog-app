package com.blog.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_posts")
public class PostEntity extends AbstractEntity{
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	@Lob
	private String description; // text
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private UserEntity user;

	@OneToMany(mappedBy = "post")
	private List<CommentEntity> comments;
	
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
	
	
}
