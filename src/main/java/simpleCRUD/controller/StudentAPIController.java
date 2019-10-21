package simpleCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import simpleCRUD.entity.Student;
import simpleCRUD.service.StudentServices;

@RestController
@RequestMapping(path = "/api")
public class StudentAPIController {

	@Autowired
	private StudentServices studentServices;
	
	@GetMapping(path="/student")
	public Iterable<Student> getAllStudent() {
		return studentServices.getAllStudent();
	}
	@PostMapping(path="/student")
	public Student createStudent(
			@RequestParam String firstName) {
		long id = studentServices.createStudent(firstName);
		return studentServices.getStudent(id);
	}
	@GetMapping(path="/student/{id}")
	public Student getStudent(
			@PathVariable long id) {
		return studentServices.getStudent(id);
	}
	@PutMapping(path="/student/{id}")
	public Student updateStudent(
			@PathVariable long id, 
			@RequestParam String firstName) {
		studentServices.updateStudent(id, firstName);
		return studentServices.getStudent(id);
	}
	@DeleteMapping(path="/student/{id}")
	public String deleteStudent(
			@PathVariable long id) {
		String name = studentServices.deleteStudent(id);
		return "Successfully delete a student with name: " + name;
	}
	@DeleteMapping(path="/student")
	public String deleteAllStudent() {
		studentServices.deleteAllStudent();
		return "Successfully delete all student";
	}
}
