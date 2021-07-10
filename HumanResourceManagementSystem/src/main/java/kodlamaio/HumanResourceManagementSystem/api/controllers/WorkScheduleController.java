package kodlamaio.HumanResourceManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkScheduleService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkSchedule;

@RestController
@RequestMapping("/api/workschedules")
@CrossOrigin
public class WorkScheduleController {
	WorkScheduleService workScheduleService;
	
	@Autowired
	public WorkScheduleController(WorkScheduleService workScheduleService) {
		this.workScheduleService = workScheduleService;
	}
	@GetMapping("/getall")
	public DataResult<List<WorkSchedule>> getAll(){
		return this.workScheduleService.getAll();
	}
}
