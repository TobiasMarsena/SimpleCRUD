package simpleCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simpleCRUD.entity.Teacher;
import simpleCRUD.repository.TeacherRepository;

@Service
public class TeacherServices {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	public long createTeacher(String name) {
		Teacher newTeacher = new Teacher();
		newTeacher.setName(name);
		teacherRepository.save(newTeacher);
		return newTeacher.getId();
	}
	public Teacher getTeacher(Long id) {
		if (teacherRepository.exists(id)) {
			return teacherRepository.findOne(id);
		} else {
			// No such Teacher exist
			return null;
		}
	}
	public Iterable<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}
	public long updateTeacher(long id, String name) {
		Teacher teacher = teacherRepository.findOne(id);
		teacher.setName(name);
		teacherRepository.save(teacher);
		return teacher.getId();
	}
	public String deleteTeacher(long id) {
		if (teacherRepository.exists(id)) {
			String name = teacherRepository.findOne(id).getName();
			teacherRepository.delete(id);
			return name;
		} else {
			return "Teacher not found";
		}
	}
	public void deleteAllTeacher() {
		teacherRepository.deleteAll();
	}
}
