package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;

public interface CvDetailDao extends JpaRepository<CvDetail, Integer> {

    CvDetail getByCandidate_Id(int candidateId);

}
