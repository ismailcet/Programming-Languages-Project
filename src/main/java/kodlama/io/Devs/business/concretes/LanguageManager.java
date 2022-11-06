package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}


	@Override
	public List<ProgrammingLanguage> getAll() {

		return languageRepository.getAll();
	}


	@Override
	public ProgrammingLanguage getLanguageById(int id) {

		return languageRepository.getLanguageById(id);
	}


	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		
		languageRepository.add(programmingLanguage);
	}
	

}
