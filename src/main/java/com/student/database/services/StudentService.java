package com.student.database.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.database.repository.Repository;
import com.student.database.tables.Student;

@Service
public class StudentService {
	@Autowired
	Repository repository;
	
	public List<Student> getAllDetails(){
		return repository.findAll();
	}
	
	public void saveStudent(Student s1) {
		
		repository.save(s1);
	}
	
	
	public Optional<Student> getById(ObjectId id) {
		return repository.findById(id);
	}

	public String delById(ObjectId id) {
		repository.deleteById(id);
		return "deleted successfully";
	}

	public void deleteStudent() {
		repository.deleteAll();
		
	}

	public void updatevalues(ObjectId id,Student s1) {
		Student old=repository.findById(id).orElse(null);
		if(old!=null) {
			old.setName(s1.getName());
			old.setBranch(s1.getBranch());
		}
		repository.save(old);
		
		
	}
}
