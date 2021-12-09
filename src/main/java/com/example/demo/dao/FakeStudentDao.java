package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
/**
 * 
 * @Repository("dao1") annotates classes at the persistence layer, which will act as a database repository.
 * 
 *
 */

@Repository("dao1")
public class FakeStudentDao implements StudentDao {

	private static List<Student> Database = new ArrayList<>();

	public int insertStudent(Student student) {
		// Create random id for students
		UUID id = UUID.randomUUID();
		// Add in the database
		Database.add(new Student(id, student.getName()));
		return 1;

	}

	public List<Student> selectAllStudents() {

		return Database;
	}

	@Override
	public int updateStudent(Student student) {
		// create a new object to select the student by id
		Optional<Student> optionalStudent = selectStudentById(student.getId());
		// if student is not found return -1
		if (!optionalStudent.isPresent()) {
			return -1;
		}

		int indexToUpdate = -1;
		
		// Use a loop to use id to find the student, found the student indexToUpdate = 1
		for (int i = 0; i < Database.size(); i++) {
			if (student.getId().equals(Database.get(i).getId())) {
				indexToUpdate = 1;
				break;
			}
		}

		if (indexToUpdate < 0) {
			return -1;
		}

		Database.set(indexToUpdate, student);
		return 1; // successful update the student name return 1 otherwise return -1
	}

	public Optional<Student> selectStudentById(UUID id) {
		
		// Use a for loop to find the student id
		for (Student s : Database) {
			if (s.getId().equals(id)) {
				return Optional.of(s);
			}
		}
		// if not found the student return empty
		return Optional.empty();
	}

	@Override
	public int deleteStudentById(UUID id) {
		Optional<Student> optionalStudent = selectStudentById(id);
		if (!optionalStudent.isPresent()) {
			return -1;
		}

		Database.remove(optionalStudent.get());
		return 1;
	}

}
