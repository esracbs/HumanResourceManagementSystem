package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkplaceCandidate;

public interface WorkplaceCandidateService {

    DataResult<List<WorkplaceCandidate>> getAll();
    DataResult<List<WorkplaceCandidate>> getByCandidateId(int candidateId);
    Result add(WorkplaceCandidate workplaceCandidate);
}
