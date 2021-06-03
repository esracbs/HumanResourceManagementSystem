package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;

public interface CvDetailService {

    DataResult<List<CvDetail>> getAll();

    DataResult<CvDetail> getByCandidateId(int candidateId);

    Result add(CvDetail cvDetail);

}
