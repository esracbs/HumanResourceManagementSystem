package kodlamaio.HumanResourceManagementSystem.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolDepartmentService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolDepartment;

@RestController
@RequestMapping("/api/schoolDepartment")
public class SchoolDepartmentController {

    private SchoolDepartmentService schoolDepartmentService;

    @Autowired
    public SchoolDepartmentController(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolDepartment>> getAll(){
        return this.schoolDepartmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.add(schoolDepartment);
    }

}
