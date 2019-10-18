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
			return studentRepository.findById(id).get();
		} else {
			// No such Student exist
			return null;
		}	
	}
	public Iterable<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	public long updateStudent(long id, String firstName) {
		Optional<Student> existingStudent = studentRepository.findById(id);
		existingStudent.get().setFirstName(firstName);
		studentRepository.save(existingStudent.get());
		return existingStudent.get().getId();
	}
	public String deleteStudent(long id) {
		if (studentRepository.existsById(id)) {
			String name = studentRepository.findById(id).get().getFirstName();
			studentRepository.delete(studentRepository.findById(id).get());
			return name;
		} else {
			return "Student not Found";
		}
	}
	public void deleteAllStudent() {
		studentRepository.deleteAll();
	}
}
