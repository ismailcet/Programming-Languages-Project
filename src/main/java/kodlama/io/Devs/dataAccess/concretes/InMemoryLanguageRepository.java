package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	List<ProgrammingLanguage> programmingLanguages; 
	
	public InMemoryLanguageRepository() {
		
		programmingLanguages=new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"Javascript"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(4,"Python"));
		programmingLanguages.add(new ProgrammingLanguage(5,"PHP"));

	}
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getLanguageById(int id) {
		for(ProgrammingLanguage language:programmingLanguages) {
			if(language.getId()==id) {
				return language;
			}
		}
		return null;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		// TODO Auto-generated method stub
		programmingLanguages.add(programmingLanguage);
	}
//
//	@Override
//	public void update(int i) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(int i) {
//		// TODO Auto-generated method stub
//		
//	}

}