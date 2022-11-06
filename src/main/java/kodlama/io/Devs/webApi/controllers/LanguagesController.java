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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

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
	public List<ProgrammingLanguage> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/language/{id}")
	public ProgrammingLanguage getLanguageById(@PathVariable("id") int id) {
		
		return languageService.getLanguageById(id);
	}
	
	@PostMapping("/language/add")
	public String add(@RequestBody ProgrammingLanguage programmingLanguage) {
		languageService.add(programmingLanguage);
		 return "Listeye "+programmingLanguage.getId() + " numaralı, " + programmingLanguage.getName() + " dili eklenmiştir.";
	}
	
	@PutMapping("/language/update")
	public String update(@RequestBody ProgrammingLanguage programmingLanguage) {
		languageService.update(programmingLanguage);
		return programmingLanguage.getId() + " numaralı dilin adı " + programmingLanguage.getName() + " olarak güncellenmiştir.";
	}
	
	@DeleteMapping("/language/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		languageService.delete(id);
		
		return id + "numaralı dil silinmiştir.";
	}
}
