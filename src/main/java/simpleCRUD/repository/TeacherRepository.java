package simpleCRUD.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import simpleCRUD.entity.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

	List<Teacher> findByName(@Param("name") String name);
}
