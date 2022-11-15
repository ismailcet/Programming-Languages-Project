package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;

public interface TechnologyService {
	
	List<GetAllTechnologyResponse> getAll();
	GetByIdTechnologyResponse getByIdTechnology(int id);
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	public void update(UpdateTechologyRequest updateTechologyRequest,int id) throws Exception;
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	

}
