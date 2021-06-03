package kodlamaio.HumanResourceManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkplaceService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Workplace;

import java.util.List;

@RestController
@RequestMapping("/api/workplaces")
public class WorkplaceController {

    private WorkplaceService workplaceService;
    @Autowired
    public WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Workplace>> getAll(){
        return workplaceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Workplace workplace){
        return workplaceService.add(workplace);
    }

}
