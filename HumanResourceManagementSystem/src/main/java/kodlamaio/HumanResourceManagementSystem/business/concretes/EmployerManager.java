package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.EmployerService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.ErrorDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.EmployerDao;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employer;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.EmployerUpdate;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private EmployerUpdateDao employerUpdateDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerUpdateDao employerUpdateDao) {
		this.employerDao = employerDao;
		this.employerUpdateDao=employerUpdateDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
	
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}
	@Override
	public DataResult<Employer> add(Employer employer) {
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş Veren Hesabı Eklendi ID:"+employer.getId());
	}
	
	@Override
    public DataResult<Employer> getById(int id) {
        if(!this.employerDao.existsById(id)){
            return new ErrorDataResult<Employer>("Böyle bir işveren yok");
        }
        return new SuccessDataResult<Employer>(this.employerDao.getById(id),"Data listelendi");
    }

    @Override
    public Result update(EmployerUpdate employerUpdate) {
        employerUpdate.setId(0);
        employerUpdate.setEmployeeId(null);
        
        Employer employer=this.employerDao.getById(employerUpdate.getEmployerId());
        this.employerUpdateDao.save(employerUpdate);
        employer.setWaitingUpdate(true);
        this.employerDao.save(employer);
        return new SuccessResult("Güncelleme isteği gönderildi personelin onayı ardından görünür olacaktır");
    }

    @Override
    public Result verifyUpdate(int employerUpdateId, int employeeId) {
        EmployerUpdate employerUpdate=this.employerUpdateDao.getById(employerUpdateId);
        Employer employer=this.employerDao.getById(employerUpdate.getEmployerId());

        employerUpdate.setVerifyed(true);
        employerUpdate.setEmployeeId(employeeId);
        this.employerUpdateDao.save(employerUpdate);

        employer.setCompanyName(employerUpdate.getCompanyName());
        employer.setPhoneNumber(employerUpdate.getPhoneNumber());
        employer.setWebAdress(employerUpdate.getWebSite());
        employer.setWaitingUpdate(false);
        this.employerDao.save(employer);
        return new SuccessResult("Bilgiler güncellendi");
    }
	
}
