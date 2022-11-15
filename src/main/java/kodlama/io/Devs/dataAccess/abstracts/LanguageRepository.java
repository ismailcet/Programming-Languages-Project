package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;


public interface LanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{

	ProgrammingLanguage getLanguageById(Integer id);
	
	Boolean existsByName(String name);

}
