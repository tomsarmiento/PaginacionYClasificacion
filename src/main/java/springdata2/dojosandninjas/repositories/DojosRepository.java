package springdata2.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdata2.dojosandninjas.models.Dojo;

@Repository
public interface DojosRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
	Dojo findByName(String name);
}
