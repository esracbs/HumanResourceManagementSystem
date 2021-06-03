package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.AbilityCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.AbilityCandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.AbilityCandidate;

@Service
public class AbilityCandidateManager implements AbilityCandidateService {

    private AbilityCandidateDao abilityCandidateDao;
    @Autowired
    public AbilityCandidateManager(AbilityCandidateDao abilityCandidateDao) {
        this.abilityCandidateDao = abilityCandidateDao;
    }


    @Override
    public DataResult<List<AbilityCandidate>> getAll() {
        return new SuccessDataResult<List<AbilityCandidate>>(abilityCandidateDao.findAll(),"yenetekler listelendi");
    }

    @Override
    public DataResult<List<AbilityCandidate>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<AbilityCandidate>>(abilityCandidateDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(AbilityCandidate abilityCandidate) {
        abilityCandidateDao.save(abilityCandidate);
        return new SuccessResult("Başarıyla eklendi");
    }
}
