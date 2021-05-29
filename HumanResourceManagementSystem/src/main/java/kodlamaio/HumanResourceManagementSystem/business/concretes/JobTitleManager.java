package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobTitleService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.ErrorResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.JobTitleDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	@Autowired
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao=jobTitleDao;
	}
	@Override
	public DataResult<List<JobTitle>> getAll(){
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}
	
	@Override
	public DataResult<JobTitle> getByTitle(String name) {
        return new SuccessDataResult<>(this.jobTitleDao.findByTitle(name));
    }
	
	@Override
	public Result add(JobTitle title) {
		if(jobTitleDao.findAllByTitle(title.getTitle()).stream().count() !=0 ) {
			return new ErrorResult("Böyle Bir İş Pozisyonu Zaten Kayıtlı");
			
		}
		this.jobTitleDao.save(title);
		return new SuccessResult("Başarıyla İş Pozisyonu Eklendi");
		
	}
	
}

