package springdata2.dojosandninjas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import springdata2.dojosandninjas.models.Ninja;

@Repository
public interface NinjasRepository extends PagingAndSortingRepository<Ninja, Long>{

}
