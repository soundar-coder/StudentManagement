package com.example.demo.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentEntity.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/api/studentDetails")
	public List<StudentEntity> getAllStudDetails(){
		return studentService.getAllStudDetails();
	}
	
	@GetMapping("/home")
	public String getHome() {
		return studentService.getHome();
	}
	
	@PostMapping("/api/studentDetails")
	public String getstudentDetails(@RequestBody StudentEntity studententity){
		return studentService.getstudentDetails(studententity);
		
		
	}
	@PutMapping("/api/studentDetails/update/{id}")
	public String updateStudentDetails(@PathVariable int id) {
		
		return  studentService.updateStudentDetails(id);
	}
	
	@DeleteMapping("/api/studentDetails/Delete/{id}")
	public String deleteMapping(@PathVariable int id) {
		return studentService.deleteMapping(id);
	}
	
	

}
