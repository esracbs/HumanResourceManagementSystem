package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.CityDao;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.EmployerDao;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobAdvertisementService;
import kodlamaio.HumanResourceManagementSystem.core.business.BusinessEngine;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.ErrorResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;

	private CityDao cityDao;
	
	private EmployerDao employerDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityDao cityDao, EmployerDao employerDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		Result engine = BusinessEngine.run(
				findCity(jobAdvertisement),
				descriptionNullChecker(jobAdvertisement),
				ifMinSalaryNull(jobAdvertisement),
				ifMaxSalaryNull(jobAdvertisement),
				minSalaryChecker(jobAdvertisement),
				maxSalaryChecker(jobAdvertisement),
				ifMinSalaryEqualsMaxSalary(jobAdvertisement) ,
				ifQuotaSmallerThanOne(jobAdvertisement),
				appealExpirationChecker( jobAdvertisement)
				);
		if(!engine.isSuccess()) {
			return new ErrorResult(engine.getMessage());
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("ilan başarıyla eklendi");
		
	}

	@Override
	public Result disableAdvertisement(int id) {
		var ref = jobAdvertisementDao.getById(id);
		if(!ref.isActive()) {
			return new ErrorResult("İlan zaten kapalı!");
		}
		else {
			ref.setActive(false);
			this.jobAdvertisementDao.save(ref);
			return new SuccessResult("İlan kapatıldı.");
		}
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return new SuccessDataResult <List<JobAdvertisement>>(this.jobAdvertisementDao.getByisActive(true),"Başarılı");		
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByAdvertisementByCompany(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(true,companyName));
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveSorted() {
		return new SuccessDataResult <List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDate(true),"Başarılı");
	}


//------------------	
	
	
	
	private Result findCity(JobAdvertisement jobAdvertisement) {
		if(!this.cityDao.existsById(jobAdvertisement.getCity().getId())) {
			return new ErrorResult("Şehir bulunamadı");
		}
		return new SuccessResult();
	}
	
	private Result descriptionNullChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getDescription().isEmpty()) {
			return new ErrorResult("İş Tanımı Boş Bırakılamaz");
		}
		return new SuccessResult();
	}
	
	private Result ifMinSalaryNull(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() == null) {
			return new ErrorResult("Minimum Maaş Girilmek Zorundadır");
		}
		return new SuccessResult();
	}
	
	
	private Result ifMaxSalaryNull(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMaxSalary() == null) {
			return new ErrorResult("Maksimum Maaş Girilmek Zorundadır");
		}
		return new SuccessResult();
	}
	
	private Result minSalaryChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() == 0) {
			return new ErrorResult("Minimum Maaş 0 verilemez");
		}
		return new SuccessResult();
	}
	
	private Result maxSalaryChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMaxSalary() == 0) {
			return new ErrorResult("Maksimum Maaş 0 verilemez");
		}
		return new SuccessResult();
	}
	
	private Result ifMinSalaryEqualsMaxSalary(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary() >= jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("Minimum Maaş Maksimum Maaşa eşit olamaz");
		}
		return new SuccessResult();
	}
	
	private Result ifQuotaSmallerThanOne(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getQuota() < 1) {
			return new ErrorResult("Açık pozisyon adedi 1 den küçük olamaz");
		}
		return new SuccessResult();
	}
	
	private Result appealExpirationChecker(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getAppealExpirationDate() == null) {
			return new ErrorResult("Son Başvuru Tarihi Girilmek Zorundadır");
		}
		return new SuccessResult();
	}
	
	
}
