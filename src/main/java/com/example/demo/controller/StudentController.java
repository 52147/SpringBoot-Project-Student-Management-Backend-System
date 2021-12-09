package com.example.demo.controller;

/**
 * = Api layer =
 * 
 *  - This class serve as an Api layer.
 * 
 *  - implement an api that get json object back.  
 *  
 *  - Dependency injection :
 *  
 *    - Use notation can split things into the service layer and API layer.
 *    - The API laer talking successfully to the service layer 
 *      and the service layer is giving some data back to the API layer.
 *    
 *  @RestController // The notation make this class to serve the restful endpoints
 *	@Autowired // add the service notation in the studentService class to tell this controller where to find the student service
 *
 */

import java.util.List;
import java.util.UUID;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {
	private StudentService studentService;

	@Autowired // auto wired the student service
	public StudentController(StudentService studentService) {

		this.studentService = studentService;
	}

	@GetMapping // mapping the http get request
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping // mapping the http post request
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);

		return "Added student!";
	}

	@PutMapping
	public String updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);

		return "Updated student!";
	}

	@DeleteMapping(path = "{id}")
	// localhost: 8080/api/student/12345
	public String deleteStudent(@PathVariable("id") UUID id) {
		studentService.deleteStudent(id);
		return "Deleted student";
	}

}