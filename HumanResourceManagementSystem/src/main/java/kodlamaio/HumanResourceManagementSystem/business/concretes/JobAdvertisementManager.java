package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.CityDao;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobAdvertisementService;
import kodlamaio.HumanResourceManagementSystem.core.business.BusinessEngine;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.ErrorResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.JobAdvertisementFilterDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;


	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao ) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
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
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult <JobAdvertisement>(this.jobAdvertisementDao.getById(id));		
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

	@Override
	public DataResult<List<JobAdvertisement>> getByIsConfirm() {
		return new SuccessDataResult <List<JobAdvertisement>>(this.jobAdvertisementDao.getByisConfirm(true));	
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsConfirmFalse() {
		return new SuccessDataResult <List<JobAdvertisement>>(this.jobAdvertisementDao.getByisConfirm(false));	
	}
	@Override
    public Result setConfirm(int id) {
        try{
        	JobAdvertisement jobAd=this.jobAdvertisementDao.getById(id);
            jobAd.setConfirm(true);
            this.jobAdvertisementDao.save(jobAd);
            return new SuccessResult("İş ilanı aktifleştirildi");
        }catch (EntityNotFoundException exception){
            return new ErrorResult("İş ilanı bulunamadı");
        }

    }
	@Override
    public DataResult<List<JobAdvertisement>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize, JobAdvertisementFilterDto jobAdFilter) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByFilter(jobAdFilter, pageable).getContent(),
        this.jobAdvertisementDao.getByFilter(jobAdFilter,pageable).getTotalElements()+"");
    }
	
}
