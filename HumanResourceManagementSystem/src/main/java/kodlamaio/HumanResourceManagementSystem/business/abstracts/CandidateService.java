package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<Candidate> add(Candidate candidate);
	DataResult<List<Candidate>> getAll();
}
