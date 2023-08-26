package kodlama.io.Devs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.Programs;

public interface ProgramRepository extends JpaRepository<Programs,Integer> {
	
	Programs findByName(String name);
}
