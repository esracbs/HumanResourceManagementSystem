package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;

public interface SchoolCandidateDao extends JpaRepository<SchoolCandidate, Integer>{
	List<SchoolCandidate> getByCandidate_Id(int candidateId);
}
