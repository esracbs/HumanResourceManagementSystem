package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> getByisActive(boolean isActive);
	List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
	JobAdvertisement getById(int id);
	List<JobAdvertisement> findAllByIsActiveOrderByCreatedDate(boolean isActive);
	List<JobAdvertisement> getByisConfirm(boolean isConfrim);

}
