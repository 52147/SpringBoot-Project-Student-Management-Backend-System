package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/**
 * = service layer=
 * 
 * - This is the service layer, which is responsible for business logic.
 * - Use the annotation to tell the class to inject the data
 * 
 * - The student service should be a spring bean, 
 *    which mean this class should be instantiated
 *
 */

@Service // Add this notation to let the studentDao class to find this class
public class StudentService {
	
	private StudentDao studentDao;

	@Autowired 
	// This student service should be auto wired for us, so studentDao will be instantiated for us and then inject into the constructor and method
	public StudentService(@Qualifier("fakeStudentDao")StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> getAllStudents() {
		return studentDao.selectAllStudents();
	}

	public int addStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
	
	public int deleteStudent(UUID id) {
		return studentDao.deleteStudentById(id);
	}

}
