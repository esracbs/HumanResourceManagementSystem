package kodlamaio.HumanResourceManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.CvDetailService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;

import java.util.List;

@RestController
@RequestMapping("/api/cvDetails")
public class CvDetailController {

    private CvDetailService cvDetailService;
    @Autowired
    public CvDetailController(CvDetailService cvDetailService) {
        this.cvDetailService = cvDetailService;
    }

    @GetMapping("/getAll")
    public DataResult<List<CvDetail>> getAll(){
        return cvDetailService.getAll();
    }

    @GetMapping("/getByCandidateId")
    public DataResult<CvDetail> getByCandidateId(int candidateId){
        return cvDetailService.getByCandidateId(candidateId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvDetail cvDetail) {
        return cvDetailService.add(cvDetail);
    }
}
