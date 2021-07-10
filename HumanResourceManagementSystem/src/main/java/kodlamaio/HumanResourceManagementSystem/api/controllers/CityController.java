package kodlamaio.HumanResourceManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.CityService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {
	private CityService cityService;
	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	@GetMapping("/getAll")
    public DataResult<List<City>> getAll(){
        return cityService.getAll();
    }

}
