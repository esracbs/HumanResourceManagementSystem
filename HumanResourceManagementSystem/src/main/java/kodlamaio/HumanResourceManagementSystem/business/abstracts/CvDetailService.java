package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.CvDto;

public interface CvDetailService {

    DataResult<List<CvDetail>> getAll();

    DataResult<CvDetail> getByCandidateId(int candidateId);

    Result add(CvDetail cvDetail);
    //DataResult<CvDto> getCandidateCvByCandidateId(int candidateId);

}
