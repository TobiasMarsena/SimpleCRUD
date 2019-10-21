package simpleCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import simpleCRUD.entity.Teacher;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@GetMapping
	public String helloTeacher(
			@RequestParam("id") long id, Model model) {
		
		RestTemplate restTemplate = new RestTemplate();
		Teacher teacher = restTemplate.getForObject("http://localhost:8080/api/teacher/" + id, Teacher.class);
		model.addAttribute("name", teacher.getName());
		return "teacher";
		
	}
}
