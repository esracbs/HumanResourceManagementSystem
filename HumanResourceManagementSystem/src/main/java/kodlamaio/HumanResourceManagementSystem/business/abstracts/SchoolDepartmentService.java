package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentService {
	DataResult<List<SchoolDepartment>> getAll();
	Result add(SchoolDepartment schoolDepartment);
}
