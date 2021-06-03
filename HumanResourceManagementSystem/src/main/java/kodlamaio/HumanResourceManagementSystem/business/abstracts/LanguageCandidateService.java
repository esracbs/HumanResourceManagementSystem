package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;

public interface LanguageCandidateService {
	DataResult<List<LanguageCandidate>> getByCandidateId(int candidateId);
	DataResult<List<LanguageCandidate>> getAll();
	Result add(LanguageCandidate languageCandidate);
}
