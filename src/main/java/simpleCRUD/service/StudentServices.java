package simpleCRUD.service;

import java.util.Optional;

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
		if (studentRepository.existsById(id)) {
			Optional<Student> student = studentRepository.findById(id);
			return student.get();
		} else {
			// No such Student exist
			return null;
		}	
	}
	public Iterable<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	public long updateStudent(long id, String firstName) {
		Student existingStudent = studentRepository.findById(id).get();
		existingStudent.setFirstName(firstName);
		studentRepository.save(existingStudent);
		return existingStudent.getId();
	}
	public String deleteStudent(long id) {
		if (studentRepository.existsById(id)) {
			Student student = studentRepository.findById(id).get();
			String name = student.getFirstName();
			studentRepository.delete(student);
			return name;
		} else {
			return "Student not Found";
		}
	}
	public void deleteAllStudent() {
		studentRepository.deleteAll();
	}
}