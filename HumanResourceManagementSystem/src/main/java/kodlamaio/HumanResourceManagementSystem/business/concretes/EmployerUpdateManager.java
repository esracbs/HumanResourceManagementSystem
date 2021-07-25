package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.EmployerUpdateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employer;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService{

private EmployerUpdateDao employerUpdateDao;
	
	@Autowired
	public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
		this.employerUpdateDao=employerUpdateDao;
	}
	@Override
	public DataResult<EmployerUpdate> getById(int id) {
		 return new SuccessDataResult<EmployerUpdate>(this.employerUpdateDao.getById(id),"Data listelendi");
	}
	@Override
	public DataResult<List<EmployerUpdate>> getAll() {
		return new SuccessDataResult<List<EmployerUpdate>>(employerUpdateDao.findAll());
	}
	
}
