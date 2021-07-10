package kodlamaio.HumanResourceManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.AbilityService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Ability;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
@CrossOrigin
public class AbilityController {

    private AbilityService abilityService;
    @Autowired
    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Ability>> getAll(){
        return abilityService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Ability ability){
        return abilityService.add(ability);
    }


}
