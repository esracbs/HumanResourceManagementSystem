package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.JobAdvertisementFilterDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> getByisActive(boolean isActive);
	List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
	JobAdvertisement getById(int id);
	List<JobAdvertisement> findAllByIsActiveOrderByCreatedDate(boolean isActive);
	List<JobAdvertisement> getByisConfirm(boolean isConfrim);
	
	@Query("Select j from kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	        +" and ((:#{#filter.jobTitleId}) IS NULL OR j.jobtitle.id IN (:#{#filter.jobTitleId}))"
	        +" and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))"
	        +" and ((:#{#filter.workScheduleId}) IS NULL OR j.workSchedule.id IN (:#{#filter.workScheduleId}))"
	        //+" and ((:#{#filter.minSalary}) IS NULL OR (:#{#filter.minSalary}) = 0 OR j.minSalary >= (:#{#filter.minSalary})) "
	        //+" and ((:#{#filter.maxSalary}) IS NULL OR (:#{#filter.maxSalary}) = 0 OR j.maxSalary <= (:#{#filter.maxSalary}))"
	        +" and j.isActive=true"
	        +" and j.isConfirm=true")
	    public Page<JobAdvertisement> getByFilter(@Param("filter") JobAdvertisementFilterDto jobAdFilter, Pageable pageable);

}
