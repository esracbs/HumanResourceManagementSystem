package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.CvDetailService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.CvDetailDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;

@Service
public class CvDetailManager implements CvDetailService {

    private CvDetailDao cvDetailDao;

	@Autowired
	public CvDetailManager(CvDetailDao cvDetailDao) {
		this.cvDetailDao = cvDetailDao;
	}

    @Override
    public DataResult<List<CvDetail>> getAll() {
        return new SuccessDataResult<List<CvDetail>>(cvDetailDao.findAll());
    }

    @Override
    public DataResult<CvDetail> getByCandidateId(int candidateId) {
        return new SuccessDataResult<CvDetail>(cvDetailDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(CvDetail cvDetail) {
        cvDetailDao.save(cvDetail);
        return new SuccessResult("eklendi");
    }
}
