package com.example.demo.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Repository.StudentRepo;
import com.example.demo.StudentEntity.StudentEntity;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private StudentRepo studRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		StudentEntity se=studRepo.findByusername(username).orElseThrow(()->new UsernameNotFoundException("user not found") );
		
		return new User(se.getUsername(),se.getPassword(),Collections.singleton(new SimpleGrantedAuthority("Userrole")));
	}
	

}
