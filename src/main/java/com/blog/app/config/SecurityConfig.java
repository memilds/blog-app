package com.blog.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserLoginService userDetailsService;
	
	// FROM WHERE USER SHOULD BE FETCHED
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Inmemeory, JpaAuthentication(db)
		// UserService Interface implements 
		// loadByUsername(String username)
		// UserNotFound ->
//		auth.inMemoryAuthentication()
//			.withUser("sijan")
//			.password(encoder.encode("password"))
//			.roles("USER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password(encoder.encode("admin"))
//			.roles("ADMIN");
		
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

	// WHICH ROUTES SHOULD WE PROTECT
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/users/**", "/posts/create-post").hasAnyRole("USER", "ADMIN")
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("email")
			.passwordParameter("password")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout=true")
			.and()
			.csrf()
			.disable();	
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
