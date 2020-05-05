package springdata2.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import springdata2.dojosandninjas.models.Dojo;
import springdata2.dojosandninjas.models.Ninja;
import springdata2.dojosandninjas.repositories.DojosRepository;
import springdata2.dojosandninjas.repositories.NinjasRepository;

@Service
public class DojosAndNinjasService {
	private final NinjasRepository njsRepo;
	private final DojosRepository djsRepo;
	
	public DojosAndNinjasService(NinjasRepository njsRepo, DojosRepository djsRepo) {
		this.djsRepo = djsRepo;
		this.njsRepo = njsRepo;
	}
	
	public List<Dojo> allDojos(){
		List<Dojo> dojos = djsRepo.findAll();
		return dojos;
	}
	
	public Dojo findDojoByName(String name) {
		return djsRepo.findByName(name);
	}
	public void createDojo(Dojo d) {
		djsRepo.save(d);
	}
	
	public void createNinja(Ninja j) {
		njsRepo.save(j);
	}
}
