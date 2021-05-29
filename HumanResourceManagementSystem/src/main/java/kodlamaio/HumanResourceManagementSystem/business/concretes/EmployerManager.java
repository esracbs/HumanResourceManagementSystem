package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.EmployerService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.ErrorDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.EmployerDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
	
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}
	@Override
	public DataResult<Employer> add(Employer employer) {
		
		if(!companyNameChecker(employer)) {
			return new ErrorDataResult<Employer>(null,"Şirket Adı Doldurulmak Zorundadır");
		}
		else if((employer.getWebAdress().isBlank() || employer.getWebAdress() == null)) {
			return new ErrorDataResult<Employer>(null,"WebSite Adresi Doldurulmak Zorundadır");
		}
		/*else if(employer.getPassword().isBlank() || employer.getPassword() == null) {
			return new ErrorDataResult<Employer>(null,"Şifre Bilgisi Doldurulmak Zorundadır");
		}*/
		else if((employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0)) {
			return new ErrorDataResult<Employer>(null,"Email Zaten Kayıtlı");
		}
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş Veren Hesabı Eklendi ID:"+employer.getId());
		
	}
	private boolean companyNameChecker(Employer employer) {
		if(employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
			return false;
		}
		return true;
	}
	
	
}
