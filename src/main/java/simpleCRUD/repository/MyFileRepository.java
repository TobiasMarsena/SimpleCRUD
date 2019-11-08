package simpleCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simpleCRUD.entity.MyFile;

@Repository
public interface MyFileRepository extends JpaRepository<MyFile, Long>{
	
}
