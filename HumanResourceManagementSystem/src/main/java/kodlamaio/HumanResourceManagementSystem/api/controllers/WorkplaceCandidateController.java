package kodlamaio.HumanResourceManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkplaceCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkplaceCandidate;

import java.util.List;

@RestController
@RequestMapping("/api/workplaceCandidates")
public class WorkplaceCandidateController {

    private WorkplaceCandidateService workplaceCandidateService;
    @Autowired
    public WorkplaceCandidateController(WorkplaceCandidateService workplaceCandidateService) {
        this.workplaceCandidateService = workplaceCandidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkplaceCandidate>> getAll(){
        return workplaceCandidateService.getAll();
    }
    @GetMapping("/getByCandidateId")
    public DataResult<List<WorkplaceCandidate>> getByCandidateId(@RequestParam int candidateId){
        return workplaceCandidateService.getByCandidateId(candidateId);
    }
    @PostMapping("/add")
    public Result add(@RequestBody WorkplaceCandidate workplaceCandidate){
        return workplaceCandidateService.add(workplaceCandidate);
    }
}
