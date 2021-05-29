package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobTitle;

public interface JobTitleService {
	Result add(JobTitle jobTitle);
	//List<JobTitle> findJobTitles(String title);
    DataResult<List<JobTitle>> getAll();
    DataResult<JobTitle> getByTitle(String name);
}
