package com.student.database.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.database.services.StudentService;
import com.student.database.tables.Student;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/home")
	public String getHome() {
		return "welcome to the student list";
	}
	
	@GetMapping
	public List<Student> getSrtudents() {
		return service.getAllDetails();
	}
	
	@PostMapping
	public String addStudent(@RequestBody Student s1) {
		service.saveStudent(s1);
		return "added succesfully";
	}
	
	@DeleteMapping
	public String delStudent() {
		service.deleteStudent();
		return "deleted succesfully";
	}
	
	@GetMapping("/{id}")
	public Student getbyStId(@PathVariable ObjectId id) {
		return service.getById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public String updateStudent(@PathVariable ObjectId id,@RequestBody Student s1) {
		service.updatevalues(id,s1);
		return "Updated successfully";
	}
	
	
	@DeleteMapping("/{id}")
	public String delbyStId(@PathVariable ObjectId id) {
		return service.delById(id);
	}
	
	
	
}
