package kodlamaio.HumanResourceManagementSystem.business.abstracts;


import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.VerificationCode;

public interface VerificationService {
	void generateCode(VerificationCode code, Integer id);
	Result verify(String verificationCode, Integer id);
}
