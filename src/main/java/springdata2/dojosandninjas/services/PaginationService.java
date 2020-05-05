package springdata2.dojosandninjas.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springdata2.dojosandninjas.models.Ninja;
import springdata2.dojosandninjas.repositories.NinjasRepository;

@Service
@Transactional
public class PaginationService {
	@Autowired
	NinjasRepository r;
	private static final int PAGE_SIZE=5; 
	
	public Page<Ninja> ninjasPerPage(int pageNumber){
		PageRequest pageReq = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(Sort.Direction.ASC, "dojo.name"));
		Page<Ninja> ninjas = r.findAll(pageReq);
		return ninjas;
	}
}
