package kodlamaio.HumanResourceManagementSystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.VerificationService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.GenerateCode;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.ErrorDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.VerificationCode;

@Service
public class VerificationManager implements VerificationService{
	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public void generateCode(VerificationCode code, Integer id) {
		code.setCode(null);
		code.setVerified(false);
		if(code.isVerified() == false) {
			GenerateCode generator = new GenerateCode();
			String code_create = generator.create();
			code.setCode(code_create);
			code.setUserId(id);
	
			verificationCodeDao.save(code);
			
		}
		return ;
		
	}

	@Override
	public Result verify(String verificationCode, Integer id) {
		VerificationCode ref = verificationCodeDao.findByUserId(id).stream().findFirst().get();
		if(ref.getCode().equals(verificationCode) && ref.isVerified() != true) {
			ref.setVerified(true);
			return  new SuccessDataResult<VerificationCode>(this.verificationCodeDao.save(ref),"Başarılı");
		}
		else if(ref.isVerified() == true) {
			return  new ErrorDataResult<VerificationCode>(null,"Zaten Doğrulanmış Hesap");
		}
		return  new ErrorDataResult<VerificationCode>(null,"Doğrulama Kodu Geçersiz");
		
	}
	
	
}
