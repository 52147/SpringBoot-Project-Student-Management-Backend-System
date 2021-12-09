package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Student;



/**
 * 
 * Data access object(dao): it's a object or interface, which is used to access data from database.
 *
 *
 * Optional class: The Optional class provides APIs for returning the value of the object 
 *                 or a default value if the object is empty.
 *                 Optional is primarily intended for use as a method return type where there is a clear need to represent "no result," 
 *                 and where using null is likely to cause errors.
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
