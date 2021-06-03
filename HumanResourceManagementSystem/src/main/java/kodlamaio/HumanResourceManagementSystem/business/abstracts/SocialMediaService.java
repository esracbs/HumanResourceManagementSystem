package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SocialMedia;

public interface SocialMediaService {

    DataResult<List<SocialMedia>> getAll();
    DataResult<List<SocialMedia>>getByCandidateId(int candidateId);
    Result add(SocialMedia socialMedia);
}
