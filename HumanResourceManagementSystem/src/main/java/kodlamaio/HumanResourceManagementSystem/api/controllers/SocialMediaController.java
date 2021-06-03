package kodlamaio.HumanResourceManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SocialMediaService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SocialMedia;

import java.util.List;

@RestController
@RequestMapping("/api/SocialMedias")
public class SocialMediaController {

    private SocialMediaService socialMediaService;
    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getAll")
    public DataResult<List<SocialMedia>> getAll(){
        return socialMediaService.getAll();
    }
    @GetMapping("/getByCandidateId")
    public DataResult<List<SocialMedia>>getByCandidateId(@RequestParam int candidateId){
        return socialMediaService.getByCandidateId(candidateId);
    }
    @PostMapping("/add")
    public Result add(@RequestBody SocialMedia socialMedia){
       return socialMediaService.add(socialMedia);
    }
}
