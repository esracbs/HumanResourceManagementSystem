package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.AbilityService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.AbilityDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Ability;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;
    @Autowired
    public AbilityManager(AbilityDao abilityDao) {
        this.abilityDao = abilityDao;
    }


    @Override
    public DataResult<List<Ability>> getAll() {
        return new SuccessDataResult<List<Ability>>(abilityDao.findAll(),"yenetekler listelendi");
    }

    @Override
    public Result add(Ability ability) {
        abilityDao.save(ability);
        return new SuccessResult("Başarıyla eklendi");
    }
}
