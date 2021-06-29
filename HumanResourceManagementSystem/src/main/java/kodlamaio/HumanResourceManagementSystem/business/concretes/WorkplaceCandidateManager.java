package kodlamaio.HumanResourceManagementSystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkplaceCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.WorkplaceCandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkplaceCandidate;

import java.util.List;
@Service
public class WorkplaceCandidateManager implements WorkplaceCandidateService {

    private WorkplaceCandidateDao workplaceCandidateDao;
    @Autowired
    public WorkplaceCandidateManager(WorkplaceCandidateDao workplaceCandidateDao) {
        this.workplaceCandidateDao = workplaceCandidateDao;
    }

    @Override
    public DataResult<List<WorkplaceCandidate>> getAll() {
        return new SuccessDataResult<List<WorkplaceCandidate>>(workplaceCandidateDao.findAll(),"listelendi");
    }
    
    @Override
    public DataResult<List<WorkplaceCandidate>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<WorkplaceCandidate>>(workplaceCandidateDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(WorkplaceCandidate workplaceCandidate) {
        workplaceCandidateDao.save(workplaceCandidate);
        return new SuccessResult("başarıyla eklendi");
    }

	@Override
	public Result update(WorkplaceCandidate workplaceCandidate, int candidateId) {
		var value = workplaceCandidateDao.getById(candidateId);
		value.setDateOfEntry(workplaceCandidate.getDateOfEntry());
		value.setDateOfQuit(workplaceCandidate.getDateOfQuit());
		value.setWorkplace(workplaceCandidate.getWorkplace());
		workplaceCandidateDao.save(value);
		return new SuccessResult();
	}
}
