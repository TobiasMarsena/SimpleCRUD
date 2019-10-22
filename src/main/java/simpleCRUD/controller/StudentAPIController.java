package simpleCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class StudentAPIController {

	@Autowired
	private StudentServices studentServices;
	
	@GetMapping(path="/student")
	public @ResponseBody Iterable<Student> getAllStudent() {
		return studentServices.getAllStudent();
	}
	@PostMapping(path="/student")
	public String createStudent(
			@RequestParam String firstName) {
		studentServices.createStudent(firstName);
		return "redirect:/";
	}
	@GetMapping(path="/student/{id}")
	public @ResponseBody Student getStudent(
			@PathVariable long id) {
		return studentServices.getStudent(id);
	}
	@PutMapping(path="/student/{id}")
	public String updateStudent(Model model,
			@PathVariable long id, 
			@RequestParam String firstName) {
		studentServices.updateStudent(id, firstName);
		model.addAttribute("students", studentServices.getAllStudent());
		return "redirect:/";
	}
	@DeleteMapping(path="/student/{id}")
	public String deleteStudent(
			@PathVariable long id) {
		studentServices.deleteStudent(id);
		return "redirect:/";
	}
	@DeleteMapping(path="/student")
	public String deleteAllStudent() {
		studentServices.deleteAllStudent();
		return "redirect:/";
	}
}
