package simpleCRUD.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import simpleCRUD.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findByFirstName(@Param("firstName") String firstName);
}
