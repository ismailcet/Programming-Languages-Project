package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguegesResponse;

public interface LanguageService {
	List<GetAllLanguegesResponse> getAll();
	GetAllLanguegesResponse getLanguageById(int id);
	public void add(CreateLanguageRequest createLanguageRequest);
	public void update(GetAllLanguegesResponse getAllLanguegesResponse);
	public void delete(int id);
}
