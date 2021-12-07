package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Student;

/**
 * 
 * Data access object(dao): it's a object or interface, which is used to access data from database.
 *
 */

public interface StudentDao {

	Optional<Student> selectStudentById(UUID id);

	// Create a list to Search students
	List<Student> selectAllStudents();

	// Add student name and id
	int insertStudent(Student student);

	// Update students id
	int updateStudent(Student student);
	
	// Delete a student by id
	int deleteStudentById(UUID id);

}
