package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.CvDto;

public interface CvDtoService {
	Result add(CvDto cvDto);
}
