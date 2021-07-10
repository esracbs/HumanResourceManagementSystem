package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;

public interface LanguageCandidateDao extends JpaRepository<LanguageCandidate, Integer>{
	List<LanguageCandidate> getByCandidate_Id(int candidateId);
	LanguageCandidate getById(int id);
}
