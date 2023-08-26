package kodlama.io.Devs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.SubTechnology;

public interface SubTechnologyRepository  extends JpaRepository<SubTechnology,Integer>{
	
	SubTechnology findByName(String name);

}
