package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.JobAdvertisementFilterDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result disableAdvertisement(int id);
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActive();
	DataResult<List<JobAdvertisement>> getByAdvertisementByCompany(String companyName);
	DataResult<List<JobAdvertisement>> findAllByIsActiveSorted();
	DataResult<List<JobAdvertisement>> getByIsConfirm();
	DataResult<List<JobAdvertisement>> getByIsConfirmFalse();
	Result setConfirm(int id);
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize, JobAdvertisementFilterDto jobAdFilter);
}
