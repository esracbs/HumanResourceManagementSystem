package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkSchedule;

public interface WorkScheduleDao extends JpaRepository<WorkSchedule, Integer>{

}
