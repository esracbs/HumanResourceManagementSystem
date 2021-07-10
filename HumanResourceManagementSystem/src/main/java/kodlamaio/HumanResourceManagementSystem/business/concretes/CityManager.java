package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.CityService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.CityDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.City;

@Service
public class CityManager implements CityService{
	private CityDao cityDao;
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao=cityDao;
	}
	@Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(cityDao.findAll());
    }
}
