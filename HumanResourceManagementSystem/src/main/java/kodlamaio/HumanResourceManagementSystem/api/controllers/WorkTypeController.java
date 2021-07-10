package kodlamaio.HumanResourceManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkTypeService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/workTypes")
@CrossOrigin
public class WorkTypeController {
	@Autowired
	private WorkTypeService workTypeService;

	public WorkTypeController(WorkTypeService workTypeService) {
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	}
}
