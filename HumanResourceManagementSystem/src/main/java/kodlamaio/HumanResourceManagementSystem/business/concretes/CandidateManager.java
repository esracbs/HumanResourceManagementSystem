package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.AbilityCandidateService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.CandidateService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.CvDetailService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageCandidateService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolCandidateService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.SocialMediaService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkplaceCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.ErrorDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.CandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService{
	
	
	private CandidateDao candidateDao;
	private WorkplaceCandidateService workplaceCandidateService;
	private SocialMediaService socialMediaService;
	private SchoolCandidateService schoolCandidateService;
	private LanguageCandidateService languageCandidateService;
	private AbilityCandidateService abilityCandidateService;
	private CvDetailService cvDetailService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			WorkplaceCandidateService workplaceCandidateService,
			SocialMediaService socialMediaService,
			CvDetailService cvDetailService,
			SchoolCandidateService schoolCandidateService,
			LanguageCandidateService languageCandidateService,
			AbilityCandidateService abilityCandidateService) {
		this.candidateDao = candidateDao;
		this.workplaceCandidateService = workplaceCandidateService;
		this.socialMediaService = socialMediaService;
		this.schoolCandidateService = schoolCandidateService;
		this.languageCandidateService = languageCandidateService;
		this.abilityCandidateService = abilityCandidateService;
		this.cvDetailService = cvDetailService;
	}
	
	@Override
	public DataResult<CvDto> getCandidateCvByCandidateId(int candidateId) {
		CvDto cvDto = new CvDto();
		cvDto.setCandidate(this.candidateDao.findById(candidateId).get());
		cvDto.setAbilityCandidates(this.abilityCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setLanguageCandidates(this.languageCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setSchoolCandidates(this.schoolCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setWorkplaceCandidates(this.workplaceCandidateService.getByCandidateId(candidateId).getData());
		cvDto.setSocialMedias(this.socialMediaService.getByCandidateId(candidateId).getData());
		cvDto.setCvDetail(this.cvDetailService.getByCandidateId(candidateId).getData());
		return new SuccessDataResult<CvDto>(cvDto,"CV Getirildi");
	}
	@Override
	public DataResult<Candidate> add(Candidate candidate) {
		if(!firstNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Ad Bilgisi Doldurulmak Zorundadır");
		}
		else if(!lastNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"SoyAdı Bilgisi Doldurulmak Zorundadır");
		}
		
		/*else if(!IdentityValidation.isRealPerson(candidate.getIdentificationNumber())) {
			return new ErrorDataResult<Candidate>(null,"Kimlik Doğrulanamadı");
		}*/
		else if(candidate.getIdentificationNumber().isBlank()) {
			return new ErrorDataResult<Candidate>(null,"Tc Kimlik Bilgisi Boş Bırakılamaz");
		}
		
		else if(!birthDateChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Doğum Tarihi Bilgisi Doldurulmak Zorundadır");
		}
		
		else if(!emailNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email Bilgisi Doldurulmak Zorundadır");
		}
		else if(!isRealEmail(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email Adresiniz Yanlış");
		}
		
		/*else if(!passwordNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Şifre Bilgisi Doldurulmak Zorundadır");
		}*/
		
		else if(candidateDao.findAllByEmail(candidate.getEmail()).stream().count() != 0 ) {
			return new ErrorDataResult<Candidate>(null,"Email Zaten Kayıtlı");
		}
		else if(candidateDao.findAllByIdentificationNumber(candidate.getIdentificationNumber()).stream().count() != 0 ) {
			return new ErrorDataResult<Candidate>(null,"TC Numarası Zaten Kayıtlı");
		}
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),"İş Arayan Hesabı Eklendi , Doğrulama Kodu Gönderildi:"+candidate.getId());
		}
	
	private boolean firstNameChecker(Candidate candidate) {
		if(Strings.isNullOrEmpty(candidate.getFirstName())){
			return false;
		}
		return true;
	}
	
	private boolean lastNameChecker(Candidate candidate) {
		if(candidate.getLastName().isBlank() || candidate.getLastName().equals(null) ) {
			return false;
		}
		return true;
	}
	
	private boolean birthDateChecker(Candidate candidate) {
		if(candidate.getBirthDate().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean emailNullChecker(Candidate candidate) {
		if(candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	
	/*private boolean passwordNullChecker(Candidate candidate) {
		if(candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return false;
		}
		return true;
	}*/
	
	private boolean isRealEmail(Candidate candidate) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(candidate.getEmail());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     return true;
	     
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Başarılı Şekilde İş Arayanlar Listelendi");
	}
	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>
		(this.candidateDao.getById(id),"Data listelendi");	
	}
}
