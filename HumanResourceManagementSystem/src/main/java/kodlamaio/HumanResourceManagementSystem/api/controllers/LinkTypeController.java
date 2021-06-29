package kodlamaio.HumanResourceManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LinkTypeService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LinkType;

import java.util.List;

@RestController
@RequestMapping("/api/linkTypes")
@CrossOrigin
public class LinkTypeController {

    private LinkTypeService linkTypeService;
    @Autowired
    public LinkTypeController(LinkTypeService linkTypeService) {
        this.linkTypeService = linkTypeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<LinkType>> getAll(){
        return linkTypeService.getAll() ;
    }

    @PostMapping("/add")
    public Result add(@RequestBody LinkType linkType){
        return linkTypeService.add(linkType);
    }

}
