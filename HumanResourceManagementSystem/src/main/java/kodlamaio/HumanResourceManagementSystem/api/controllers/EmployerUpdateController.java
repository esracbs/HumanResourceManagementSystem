package kodlamaio.HumanResourceManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.EmployerUpdateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employer;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employerUpdates")
@CrossOrigin
public class EmployerUpdateController {
	
	@Autowired
	private EmployerUpdateService employerUpdateService;

	public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
		super();
		this.employerUpdateService = employerUpdateService;
	}
	@GetMapping("/getall")
	public DataResult<List<EmployerUpdate>> getAll(){
		return this.employerUpdateService.getAll();
	}
	
	@GetMapping("/getById")
    DataResult<EmployerUpdate> getById(@RequestParam int id){
        return this.employerUpdateService.getById(id);
    }
}
