package com.student.database.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.database.tables.Student;

public interface Repository extends MongoRepository<Student, ObjectId> {

}
