package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkTypeService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{
	private WorkTypeDao workTypeDao;
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		this.workTypeDao = workTypeDao;
	}
	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(workTypeDao.findAll());
	}
	
}
