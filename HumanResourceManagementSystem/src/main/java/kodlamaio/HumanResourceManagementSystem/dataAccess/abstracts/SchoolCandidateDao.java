package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;

public interface SchoolCandidateDao extends JpaRepository<SchoolCandidate, Integer>{
}
