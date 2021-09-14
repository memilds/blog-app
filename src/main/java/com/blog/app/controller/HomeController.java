package com.blog.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.app.config.CurrentlyLoggedInUser;
import com.blog.app.domains.PostDomain;
import com.blog.app.domains.UserDomain;
import com.blog.app.service.PostService;
import com.blog.app.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String goHome(Model model, Authentication authentication) {
		int loggedInUserId = 0;
		if(authentication != null) {
			CurrentlyLoggedInUser user = (CurrentlyLoggedInUser) authentication.getPrincipal();
			loggedInUserId = user.getUserId();
		}
		
		List<PostDomain> posts = postService.findAll();
		model.addAttribute("posts", posts);
		model.addAttribute("size", posts.size());
		model.addAttribute("loggedInUserId", loggedInUserId);
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("userDomain", new UserDomain());
		return "login";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserDomain userDomain) {
		UserDomain fetchedUserDomain = this.userService.getByEmail(userDomain.getEmail());
		if(fetchedUserDomain != null) {
			return "redirect:/login?error=This email already exists in our system";
		}
		
		userDomain.setRole("ROLE_USER");
		this.userService.add(userDomain);
		return "redirect:/login?success=true";
	}
}
