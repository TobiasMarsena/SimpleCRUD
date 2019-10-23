package simpleCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simpleCRUD.entity.Student;
import simpleCRUD.repository.StudentRepository;

@Service
public class StudentServices {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public long createStudent(String firstName) {
		Student newStudent = new Student();
		newStudent.setFirstName(firstName);
		studentRepository.save(newStudent);
		return newStudent.getId();
	}
	public Student getStudent(Long id) {
		if (studentRepository.exists(id)) {
			Student student = studentRepository.findOne(id);
			return student;
		} else {
			// No such Student exist
			return null;
		}	
	}
	public Iterable<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	public long updateStudent(long id, String firstName) {
		Student existingStudent = studentRepository.findOne(id);
		existingStudent.setFirstName(firstName);
		studentRepository.save(existingStudent);
		return existingStudent.getId();
	}
	public String deleteStudent(long id) {
		if (studentRepository.exists(id)) {
			String name = studentRepository.findOne(id).getFirstName();
			studentRepository.delete(studentRepository.findOne(id));
			return name;
		} else {
			return "Student not Found";
		}
	}
	public void deleteAllStudent() {
		studentRepository.deleteAll();
	}
}