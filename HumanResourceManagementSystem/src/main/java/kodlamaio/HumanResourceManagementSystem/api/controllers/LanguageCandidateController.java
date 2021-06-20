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

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;

@RestController
@RequestMapping("/api/languageCandidates")
@CrossOrigin
public class LanguageCandidateController {
	private LanguageCandidateService languageCandidateService;

	@Autowired
	public LanguageCandidateController(LanguageCandidateService languageCandidateService) {
		super();
		this.languageCandidateService = languageCandidateService;
	}
	@GetMapping("/getall")
    public DataResult<List<LanguageCandidate>> getAll(){
        return this.languageCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageCandidate languageCandidate){
        return this.languageCandidateService.add(languageCandidate);
    }
    @GetMapping("/getByCandidateId")
    public DataResult<List<LanguageCandidate>> getByCandidateId(@RequestParam int candidateId){
        return languageCandidateService.getByCandidateId(candidateId);
    }
	
}
