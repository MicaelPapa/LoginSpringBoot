package com.springsecurity.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/login").permitAll()
		.antMatchers("/","/error").permitAll()
		.antMatchers("/user").access("hasRole('USER')")
		.anyRequest().authenticated().and()
		.formLogin().loginPage("/login")
		.permitAll()
		.defaultSuccessUrl("/menu")
		.failureUrl("/error")
		.usernameParameter("username")
		.passwordParameter("pass").and()
		.logout().
		permitAll().logoutSuccessUrl("/login");
	}
	
	BCryptPasswordEncoder encoder;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		encoder = new BCryptPasswordEncoder(4);
		return encoder;
	}
	
}	
