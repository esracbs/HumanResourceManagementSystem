package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.SchoolDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(schoolDao.findAll());
    }

    @Override
    public Result add(School school) {
        schoolDao.save(school);
        return new SuccessResult("başarıyla eklendi");
    }
	
}
