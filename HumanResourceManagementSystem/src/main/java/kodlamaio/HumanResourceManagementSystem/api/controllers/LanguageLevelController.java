package kodlamaio.HumanResourceManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageCandidateService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageLevelService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageLevel;

@RestController
@RequestMapping("/api/languageLevel")
@CrossOrigin
public class LanguageLevelController {
	private LanguageLevelService languageLevelService;

	@Autowired
	public LanguageLevelController(LanguageLevelService languageLevelService) {
		super();
		this.languageLevelService = languageLevelService;
	}
	@GetMapping("/getall")
    public DataResult<List<LanguageLevel>> getAll(){
        return this.languageLevelService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageLevel languageLevel){
        return this.languageLevelService.add(languageLevel);
    }
}
