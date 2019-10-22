package simpleCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import simpleCRUD.entity.Student;
import simpleCRUD.service.StudentServices;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	private StudentServices studentServices;
	
	@GetMapping
	public String helloStudent(
			@RequestParam("id") long id, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject("http://localhost:8080/api/student/"+id, Student.class);
		model.addAttribute("name", student.getFirstName());
		return "student";
	}
	@GetMapping(path = "/edit/{id}")
	public String editStudent(
			@PathVariable long id,
			Model model) {
		model.addAttribute("student", studentServices.getStudent(id));
		return "editStudent";
	}
	@GetMapping(path = "/delete/{id}")
	public String deleteStudent(
			@PathVariable long id,
			Model model) {
		model.addAttribute("student", studentServices.getStudent(id));
		return "deleteWarning";
	}
	@GetMapping(path = "/signup")
	public String createStudent(Model model) {
		model.addAttribute("student", new Student());
		return "createStudent";
	}
}