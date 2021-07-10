package kodlamaio.HumanResourceManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.AbilityCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.AbilityCandidate;

import java.util.List;

@RestController
@RequestMapping("/api/abilityCandidates")
@CrossOrigin
public class AbilityCandidateController {

    private AbilityCandidateService abilityCandidateService;
    @Autowired
    public AbilityCandidateController(AbilityCandidateService abilityCandidateService) {
        this.abilityCandidateService = abilityCandidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<AbilityCandidate>> getAll(){
        return abilityCandidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody AbilityCandidate abilityCandidate){
        return abilityCandidateService.add(abilityCandidate);
    }
    @GetMapping("/getByCandidateId")
    public DataResult<List<AbilityCandidate>> getByCandidateId(@RequestParam int candidateId){
        return abilityCandidateService.getByCandidateId(candidateId);
    }
    @PostMapping("/update")
	public Result update(@RequestBody AbilityCandidate abilityCandidate,@RequestParam int id){
		return this.abilityCandidateService.update(abilityCandidate,id);
	}

}