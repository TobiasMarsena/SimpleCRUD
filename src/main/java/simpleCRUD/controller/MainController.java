package simpleCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import simpleCRUD.entity.MyFile;
import simpleCRUD.repository.MyFileRepository;
import simpleCRUD.service.StudentServices;

@Controller
public class MainController {
	
	@Autowired
	private StudentServices studentServices;
	@Autowired
	private MyFileRepository myFileRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/home";
	}
	@GetMapping("/login")
	public String login() {
		return "index";
	}
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/access-denied";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("students", studentServices.getAllStudent());
		return "home";
	}
	
	@GetMapping("/upload")
	public String upload(Model model) {
		
//		TO DO - get all uploaded file and add as attribute to Thymeleaf
		List<MyFile> files = myFileRepository.findAll();
		model.addAttribute("files", files);
		
		return "upload";
	}
	
}
