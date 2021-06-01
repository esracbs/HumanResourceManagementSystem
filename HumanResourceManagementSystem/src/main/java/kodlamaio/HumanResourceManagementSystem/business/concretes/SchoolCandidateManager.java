package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.SchoolCandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;

@Service
public class SchoolCandidateManager implements SchoolCandidateService {

    private SchoolCandidateDao schoolCandidateDao;
    @Autowired
    public SchoolCandidateManager(SchoolCandidateDao schoolCandidateDao) {
        this.schoolCandidateDao = schoolCandidateDao;
    }

    @Override
    public DataResult<List<SchoolCandidate>> getAll() {
        return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.findAll());
    }

    @Override
    public Result add(SchoolCandidate schoolCandidate) {
        schoolCandidateDao.save(schoolCandidate);
        return new SuccessResult("eklendi");
    }
}
