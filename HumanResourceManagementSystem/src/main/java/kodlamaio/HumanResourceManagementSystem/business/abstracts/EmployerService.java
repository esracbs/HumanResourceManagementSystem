package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employer;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.EmployerUpdate;

public interface EmployerService {
	DataResult<Employer> add(Employer employer);
	DataResult<List<Employer>> getAll();
	//DataResult<Employer> getByemail(String email);
	DataResult<Employer> getById(int id);
	Result update(EmployerUpdate employerUpdate);
    Result verifyUpdate(int employerUpdateId,int staffId);
}
