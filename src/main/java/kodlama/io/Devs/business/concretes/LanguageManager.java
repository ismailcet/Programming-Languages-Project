package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguegesResponse;
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
	public List<GetAllLanguegesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages=languageRepository.findAll();
		List<GetAllLanguegesResponse> languagesResponses=new ArrayList<GetAllLanguegesResponse>();
		
		
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
			GetAllLanguegesResponse responseItem=new GetAllLanguegesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			
			languagesResponses.add(responseItem);
		}
		return languagesResponses;

	}


	@Override
	public GetAllLanguegesResponse getLanguageById(int id) {

		ProgrammingLanguage language = this.languageRepository.findById(id).get();
		GetAllLanguegesResponse getAllLanguegesResponse = new GetAllLanguegesResponse();
		
		getAllLanguegesResponse.setId(language.getId());
		getAllLanguegesResponse.setName(language.getName());
		
		return getAllLanguegesResponse;
	}


	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createLanguageRequest.getName());
		
		this.languageRepository.save(programmingLanguage);
		
	}


	@Override
	public void update(GetAllLanguegesResponse getAllLanguegesResponse) {
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		
		programmingLanguage.setId(getAllLanguegesResponse.getId());
		programmingLanguage.setName(getAllLanguegesResponse.getName());
		
		languageRepository.save(programmingLanguage);
	}


	@Override
	public void delete(int id) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		
		programmingLanguage.setId(id);
		languageRepository.delete(programmingLanguage);;
		
	}
	
	

}
