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

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;

@RestController
@RequestMapping("/api/schoolCandidates")
@CrossOrigin
public class SchoolCandidateController {

    private SchoolCandidateService schoolCandidateService;

    @Autowired
    public SchoolCandidateController(SchoolCandidateService schoolCandidateService) {
        this.schoolCandidateService = schoolCandidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolCandidate>> getAll(){
        return this.schoolCandidateService.getAll();
    }
    @GetMapping("/getByCandidateId")
    public DataResult<List<SchoolCandidate>> getByCandidateId(@RequestParam int candidateId){
        return schoolCandidateService.getByCandidateId(candidateId);
    }
    @PostMapping("/add")
    public Result add(@RequestBody SchoolCandidate schoolCandidate){
        return this.schoolCandidateService.add(schoolCandidate);
    }


}
