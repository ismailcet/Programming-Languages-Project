package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;


public interface LanguageRepository {
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getLanguageById(int id);
    void add(ProgrammingLanguage programmingLanguage);
//	void update(int i);
//	void delete(int i);
	
}
