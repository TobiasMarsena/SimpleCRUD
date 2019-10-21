package simpleCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import simpleCRUD.entity.Student;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

	@GetMapping
	public String helloStudent(
			@RequestParam("id") long id, Model model) {
		
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject("http://localhost:8080/api/student/"+id, Student.class);
		model.addAttribute("name", student.getFirstName());
		return "student";
	}
}