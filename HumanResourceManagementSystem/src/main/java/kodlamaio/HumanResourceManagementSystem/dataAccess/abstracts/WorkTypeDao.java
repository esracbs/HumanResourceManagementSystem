package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer>{

}
