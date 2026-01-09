package com.example.demo.SecurityConfig;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailService() {
		return (UserDetailsService) new CustomUserDetailsService();
	}
	  
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 
		http.authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.POST,"/api/studentDetails").permitAll()
				.requestMatchers("/api/studentDetails/**").authenticated()
				.requestMatchers("/home").permitAll().anyRequest().permitAll())
		.formLogin(form -> form.permitAll()).csrf(csrf -> csrf.disable());
		return http.build();	
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailService());
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	

}

