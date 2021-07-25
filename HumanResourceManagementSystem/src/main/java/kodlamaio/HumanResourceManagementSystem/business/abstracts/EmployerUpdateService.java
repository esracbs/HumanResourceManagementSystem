package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {
	DataResult<EmployerUpdate> getById(int id);
	DataResult<List<EmployerUpdate>> getAll();
}
