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

import simpleCRUD.entity.Teacher;
import simpleCRUD.service.TeacherServices;

@RestController
@RequestMapping("/api/teacher")
public class TeacherAPIController {
	
	@Autowired
	private TeacherServices teacherServices;
	
	@PostMapping
	public Teacher createTeacher(
			@RequestParam String name) {
		long id = teacherServices.createTeacher(name);
		return teacherServices.getTeacher(id);
	}
	@GetMapping
	public Iterable<Teacher> getAllTeacher() {
		return teacherServices.getAllTeacher();
	}
	@GetMapping(path="{id}")
	public Teacher getTeacher(
			@PathVariable long id) {
		return teacherServices.getTeacher(id);
	}
	@PutMapping(path="{id}")
	public Teacher updateTeacher(
			@PathVariable long id,
			@RequestParam String name) {
		teacherServices.updateTeacher(id, name);
		return teacherServices.getTeacher(id);
	}
	@DeleteMapping
	public void deleteAllTeacher() {
		teacherServices.deleteAllTeacher();
	}
	@DeleteMapping(path="{id}")
	public void deleteTeacher(
			@PathVariable long id) {
		teacherServices.deleteTeacher(id);
	}
}
