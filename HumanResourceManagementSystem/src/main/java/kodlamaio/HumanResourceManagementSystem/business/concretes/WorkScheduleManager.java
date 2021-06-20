package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkScheduleService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.WorkScheduleDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkSchedule;

@Service
public class WorkScheduleManager implements WorkScheduleService{
	private WorkScheduleDao workScheduleDao;
	
	@Autowired
	public WorkScheduleManager(WorkScheduleDao workhsScheduleDao) {
		this.workScheduleDao = workhsScheduleDao;
	}
	@Override
	public DataResult<List<WorkSchedule>> getAll() {
		return new SuccessDataResult<List<WorkSchedule>>(workScheduleDao.findAll());
	}
	
}
