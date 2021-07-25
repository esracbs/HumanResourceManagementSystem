package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	List<Employee> getById(int id);
}
