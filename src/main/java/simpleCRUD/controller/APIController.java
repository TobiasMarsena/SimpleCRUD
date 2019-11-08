package simpleCRUD.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import simpleCRUD.entity.MyFile;
import simpleCRUD.repository.MyFileRepository;

@Controller
@RequestMapping(path = "/api")
public class APIController {

	@Autowired
	MyFileRepository myFileRepository;
	
	@PostMapping(path = "/uploadFile")
	public String uploadFile(
			@RequestParam("file") MultipartFile file) throws IOException {
	
		MyFile myFile = new MyFile(file.getOriginalFilename(), file.getBytes());
		myFileRepository.save(myFile);
	
		return "redirect:/upload";
	}
}
