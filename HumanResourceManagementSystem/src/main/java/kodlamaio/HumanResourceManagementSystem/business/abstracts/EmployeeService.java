package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	DataResult<List<Employee>> getById(int id);
	Result add(Employee employee);
	Result update(Employee employee,int id);
}
