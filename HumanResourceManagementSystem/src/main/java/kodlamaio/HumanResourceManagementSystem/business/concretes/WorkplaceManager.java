package kodlamaio.HumanResourceManagementSystem.business.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkplaceService;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.WorkplaceDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Workplace;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;

import java.util.List;
@Service
public class WorkplaceManager implements WorkplaceService {

    private WorkplaceDao workplaceDao;
    @Autowired
    public WorkplaceManager(WorkplaceDao workplaceDao) {
        this.workplaceDao = workplaceDao;
    }

    @Override
    public DataResult<List<Workplace>> getAll() {
        return new SuccessDataResult<List<Workplace>>(workplaceDao.findAll());
    }

    @Override
    public Result add(Workplace workplace) {
        workplaceDao.save(workplace);
        return new SuccessResult("başarıyla eklendi");
    }
}
