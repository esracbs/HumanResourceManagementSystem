package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	Candidate getById(int id);
	List<Candidate> findAllByEmail(String email);
	List<Candidate> findAllByIdentificationNumber(String identificationNumber);
}
