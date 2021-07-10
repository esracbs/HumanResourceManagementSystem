package kodlamaio.HumanResourceManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobTitleService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
@CrossOrigin
public class JobTitleController {
	private JobTitleService jobTitleService;
	
	@Autowired
	public JobTitleController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService=jobTitleService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobTitle>> getAll(){
        return this.jobTitleService.getAll();
    }
	@PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle){
        return this.jobTitleService.add(jobTitle);
    }
	@RequestMapping(value = "/findbytitle", method = RequestMethod.GET)
	public DataResult<JobTitle> findByTitle(@PathVariable("title") String title){
		return jobTitleService.getByTitle(title);
	}
	
}
