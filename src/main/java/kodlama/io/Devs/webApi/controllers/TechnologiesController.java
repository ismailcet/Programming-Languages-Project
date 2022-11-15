package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateTechologyRequest;
import kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
		technologyService.add(createTechnologyRequest);
	}
	@PutMapping("/update")
	public void update(UpdateTechologyRequest updateTechologyRequest,int id) throws Exception{
		technologyService.update(updateTechologyRequest, id);
	}
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteRequest) {
		technologyService.delete(deleteRequest);
	}
}
