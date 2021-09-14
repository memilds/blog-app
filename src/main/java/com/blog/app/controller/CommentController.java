package com.blog.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.app.domains.CommentDomain;
import com.blog.app.service.CommentService;

@Controller
@RequestMapping("/posts")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/{id}/comments")
	public String processPostComments(@PathVariable("id") int id, @ModelAttribute @Valid CommentDomain commentDomain,
			BindingResult result) {
		if (result.hasErrors()) {
			return "post-details";
		}

		commentDomain.setPostId(id);
		this.commentService.add(commentDomain);
		return "redirect:/posts/" + id + "/details";
	}




}
