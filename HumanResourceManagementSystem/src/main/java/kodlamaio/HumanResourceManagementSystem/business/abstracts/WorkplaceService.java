package kodlamaio.HumanResourceManagementSystem.business.abstracts;


import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Workplace;

public interface WorkplaceService {

    DataResult<List<Workplace>> getAll();

    Result add(Workplace workplace);

}
