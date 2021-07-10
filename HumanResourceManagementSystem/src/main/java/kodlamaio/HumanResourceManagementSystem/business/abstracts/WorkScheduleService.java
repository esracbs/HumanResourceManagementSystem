package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkSchedule;

public interface WorkScheduleService {
	DataResult<List<WorkSchedule>> getAll();
}
