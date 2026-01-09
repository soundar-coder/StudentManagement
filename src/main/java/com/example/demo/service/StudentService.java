package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.StudentRepo;
import com.example.demo.StudentEntity.StudentEntity;

@Service
public class StudentService {
	@Autowired
	StudentRepo studRepo;
	
	@Autowired
	private PasswordEncoder pe;
	public String getHome() {
		return "Welcome Home";
	}
	
	public String getstudentDetails(StudentEntity se) {
		se.setPassword(pe.encode(se.getPassword()));
		studRepo.save(se);
		return "Student Data stored succesfully";
	}

	public String updateStudentDetails(int id) {
		StudentEntity s1= studRepo.findById(id).orElseThrow();
		s1.setName("yogesh");
		s1.setMark(99);
		studRepo.save(s1);
		return "updated successfull";
	}

	public String deleteMapping(int id) {
		studRepo.deleteById(id);
		return "Deleted Successfully";
	}
	
	public List<StudentEntity> getAllStudDetails(){
		return  studRepo.findAll();
	}

	

}
