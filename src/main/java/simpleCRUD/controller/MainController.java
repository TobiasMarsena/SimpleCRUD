package simpleCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import simpleCRUD.service.StudentServices;

@Controller
public class MainController {
	
	@Autowired
	private StudentServices studentServices;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("students", studentServices.getAllStudent());
		return "home";
	}
	
}
