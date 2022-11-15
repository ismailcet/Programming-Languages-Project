package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	
	private TechnologyRepository technologyRepository;
	
	private LanguageRepository languageRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository,LanguageRepository languageRepository) {
		super();
		this.technologyRepository=technologyRepository;
		this.languageRepository = languageRepository;
	}
	
	@Override
	public List<GetAllTechnologyResponse> getAll() {
		
		List<Technology> technologies=technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponses=new ArrayList<GetAllTechnologyResponse>();
		
		for(Technology technology:technologies) {
			GetAllTechnologyResponse responseItem=new GetAllTechnologyResponse();
			
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			responseItem.setLanguageId(technology.getLanguage().getId());
			responseItem.setLanguageName(technology.getLanguage().getName());
			
			technologyResponses.add(responseItem);
		}
		
		return technologyResponses;
		
	}

	@Override
	public GetByIdTechnologyResponse getByIdTechnology(int id) {
		Technology technology = this.technologyRepository.getById(id);
		
		GetByIdTechnologyResponse getByIdTechnologyResponse = new GetByIdTechnologyResponse();
		
		getByIdTechnologyResponse.setId(technology.getId());
		
		return getByIdTechnologyResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
		Technology technology=new Technology();
		
		ProgrammingLanguage language = languageRepository.getLanguageById(createTechnologyRequest.getLanguageId());
		if(technologyRepository.existsByName(createTechnologyRequest.getName())) {
			throw new Exception("This tech is already exists.");
		}
		else if(languageRepository.existsById(createTechnologyRequest.getLanguageId())) {
			technology.setName(createTechnologyRequest.getName());
			technology.setLanguage(language);
			this.technologyRepository.save(technology);
		}else {
			throw new Exception("Language Not Found ! ");
		}
		
	}

	@Override
	public void update(UpdateTechologyRequest updateTechologyRequest ,int id) throws Exception{

		if(technologyRepository.existsByName(updateTechologyRequest.getName())) {
			throw new Exception("This tech already exists.");
		}
		else if (technologyRepository.existsById(updateTechologyRequest.getLanguageId())) {
			Technology technology = technologyRepository.getTechnologyById(id);
			technology.setName(updateTechologyRequest.getName());
			
			ProgrammingLanguage language = languageRepository.getLanguageById(updateTechologyRequest.getLanguageId());
			technology.setLanguage(language);
			this.technologyRepository.save(technology);
		}else {
			throw new Exception("Language not found.");
		}
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {

		technologyRepository.deleteById(deleteTechnologyRequest.getId());
	}

}
