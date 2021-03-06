package kodlamaio.HumanResourceManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobAdvertisementService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.JobAdvertisementFilterDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>>  getAll(){
		return this.jobAdvertisementService.getAll();
	}
	@GetMapping("/getByIsActivated")
	public DataResult<List<JobAdvertisement>> getByIsActivated(){
		return jobAdvertisementService.getByIsActive();
	}
	@GetMapping("/getAllSortedByDate")
	public DataResult<List<JobAdvertisement>> getAllSortedByDate(){
		return jobAdvertisementService.findAllByIsActiveSorted();
	}
	@GetMapping("/getByAdvertisementByCompany")
	public DataResult<List<JobAdvertisement>> getByAdvertisementByCompany(@RequestParam String companyName){
		return jobAdvertisementService.getByAdvertisementByCompany(companyName);
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		System.out.println(jobAdvertisement);
		return jobAdvertisementService.add(jobAdvertisement);
	}
	@PostMapping("/disableAdvertisement")
	public Result closeAdvertisement(@RequestParam int id) {
		return jobAdvertisementService.disableAdvertisement(id);
	}
	@GetMapping("/getByIsConfirm")
	public DataResult<List<JobAdvertisement>> getByIsConfirm(){
		return jobAdvertisementService.getByIsConfirm();
	}
	@GetMapping("/getByIsConfirmedFalse")
	public DataResult<List<JobAdvertisement>> getByIsConfirmFalse(){
		return jobAdvertisementService.getByIsConfirmFalse();
	}
	@PostMapping("/setConfirm")
    public ResponseEntity<?> setConfirm(@RequestParam int id){
        Result result=this.jobAdvertisementService.setConfirm(id);
        if(!result.isSuccess()){
            ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestParam int id){
		return this.jobAdvertisementService.getById(id);
	}
	@PostMapping("/getByActiveAndFilter")
    public Result getByActiveAndFilter(@RequestParam int pageNo,@RequestParam int pageSize,@RequestBody JobAdvertisementFilterDto jobAdFilter){
        return jobAdvertisementService.getByIsActiveAndPageNumberAndFilter(pageNo,pageSize,jobAdFilter);
    }
}
