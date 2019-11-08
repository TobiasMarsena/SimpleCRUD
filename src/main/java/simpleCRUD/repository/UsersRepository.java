package simpleCRUD.repository;

import org.springframework.stereotype.Repository;
import simpleCRUD.entity.Users;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

}
