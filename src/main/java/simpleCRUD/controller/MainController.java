package simpleCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import simpleCRUD.entity.Student;
import simpleCRUD.service.StudentServices;

@Controller
@RequestMapping(path = "/api")
public class MainController {

	@Autowired
	private StudentServices studentServices;
	
	@GetMapping(path="/student")
	public @ResponseBody Iterable<Student> getAllStudent() {
		return studentServices.getAllStudent();
	}
	@PostMapping(path="/student")
	public @ResponseBody Student createStudent(
			@RequestParam String firstName) {
		long id = studentServices.createStudent(firstName);
		return studentServices.getStudent(id);
	}
	@GetMapping(path="/student/{id}")
	public @ResponseBody Student getStudent(
			@PathVariable Long id) {
		return studentServices.getStudent(id);
	}
	@PutMapping(path="/student/{id}")
	public @ResponseBody Student updateStudent(
			@PathVariable Long id, 
			@RequestParam String firstName) {
		studentServices.updateStudent(id, firstName);
		return studentServices.getStudent(id);
	}
	@DeleteMapping(path="/student/{id}")
	public String deleteStudent(
			@PathVariable Long id) {
		studentServices.deleteStudent(id);
		return "Successfully delete a student with id: " + id;
	}
	@DeleteMapping(path="/student")
	public String deleteAllStudent() {
		studentServices.deleteAllStudent();
		return "Successfully delete all student";
	}
	
	
}
