package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface LanguageService {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getLanguageById(int id);
	public void add(ProgrammingLanguage programmingLanguage);
	public void update(ProgrammingLanguage programmingLanguage);
	public void delete(int id);
}
