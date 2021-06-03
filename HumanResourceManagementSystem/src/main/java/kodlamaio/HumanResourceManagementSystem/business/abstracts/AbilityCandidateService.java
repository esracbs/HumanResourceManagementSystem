package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.AbilityCandidate;

public interface AbilityCandidateService {
	Result add(AbilityCandidate abilityCandidate);
	DataResult<List<AbilityCandidate>> getAll();
	DataResult<List<AbilityCandidate>> getByCandidateId(int candidateId);
}
