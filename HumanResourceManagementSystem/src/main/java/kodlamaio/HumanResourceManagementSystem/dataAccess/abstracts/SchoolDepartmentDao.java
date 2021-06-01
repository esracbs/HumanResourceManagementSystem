package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer>{

}
