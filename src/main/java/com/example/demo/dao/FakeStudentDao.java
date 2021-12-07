package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

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

		Optional<Student> optionalStudent = selectStudentById(student.getId());
		if (!optionalStudent.isPresent()) {
			return -1;
		}

		int indexToUpdate = -1;
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
		return 1;
	}

	public Optional<Student> selectStudentById(UUID id) {
		for (Student s : Database) {
			if (s.getId().equals(id)) {
				return Optional.of(s);
			}
		}
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
