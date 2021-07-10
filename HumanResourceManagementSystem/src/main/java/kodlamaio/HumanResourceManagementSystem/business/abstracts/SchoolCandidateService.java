package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;

public interface SchoolCandidateService {
	DataResult<List<SchoolCandidate>> getByCandidateId(int candidateId);
	DataResult<List<SchoolCandidate>> getAll();
	Result add(SchoolCandidate schoolCandidate);
}
