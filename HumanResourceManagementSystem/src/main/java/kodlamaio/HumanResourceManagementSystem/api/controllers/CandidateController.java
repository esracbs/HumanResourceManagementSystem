package kodlamaio.HumanResourceManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.CandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin
public class CandidateController {
	
	private CandidateService candidateService;
	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<Candidate> add(@RequestBody Candidate candidate){
		return this.candidateService.add(candidate);
	}
	@GetMapping("/getCandidateCvByCandidateId")
	public DataResult<CvDto> getCandidateCvByCandidateId(int candidateId){
		return candidateService.getCandidateCvByCandidateId(candidateId);
	}
	@GetMapping("/getByCandidateId")
	public DataResult<Candidate> getById(@RequestParam int id){
		return this.candidateService.getById(id);
	}
}
