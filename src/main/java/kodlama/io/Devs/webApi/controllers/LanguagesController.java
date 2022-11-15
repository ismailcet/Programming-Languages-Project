package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllLanguegesResponse;

@RestController
@RequestMapping("/api/")
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/languages/getall")
	public List<GetAllLanguegesResponse> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/language/{id}")
	public GetAllLanguegesResponse getLanguageById(@PathVariable("id") int id) {
		
		return languageService.getLanguageById(id);
	}
	
	@PostMapping("/language/add")
	public String add(@RequestBody CreateLanguageRequest createLanguageRequest) {
		languageService.add(createLanguageRequest);
		 return "Listeye "+ createLanguageRequest.getName() + " dili eklenmiştir.";
	}
	
	@PutMapping("/language/update")
	public String update(@RequestBody GetAllLanguegesResponse getAllLanguegesResponse) {
		languageService.update(getAllLanguegesResponse);
		return getAllLanguegesResponse.getId() + " numaralı dilin adı " + getAllLanguegesResponse.getName() + " olarak güncellenmiştir.";
	}
	
	@DeleteMapping("/language/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		languageService.delete(id);
		
		return id + "numaralı dil silinmiştir.";
	}
}
