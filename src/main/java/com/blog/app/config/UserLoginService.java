package com.blog.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.app.entity.UserEntity;
import com.blog.app.repo.UserRepository;

@Service
public class UserLoginService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity entity = this.userRepository.findByEmail(email);
		if(email == null) {
			throw new UsernameNotFoundException("Email doesn't exists.");
		}
		
		
		return new CurrentlyLoggedInUser(email, 
				entity.getPassword(), 
				List.of(new SimpleGrantedAuthority(entity.getRole())),
				entity.getId()
				);
	}

}
