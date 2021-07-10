package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.LanguageCandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;

@Service
public class LanguageCandidateManager implements LanguageCandidateService{
	@Autowired
	private LanguageCandidateDao languageCandidateDao;
	
	public LanguageCandidateManager(LanguageCandidateDao languageCandidateDao) {
		super();
		this.languageCandidateDao = languageCandidateDao;
	}

	@Override
	public DataResult<List<LanguageCandidate>> getAll() {
		return new SuccessDataResult<List<LanguageCandidate>>(this.languageCandidateDao.findAll());
	}
	 @Override
	    public DataResult<List<LanguageCandidate>> getByCandidateId(int candidateId) {
	        return new SuccessDataResult<List<LanguageCandidate>>(languageCandidateDao.getByCandidate_Id(candidateId));
	    }
	@Override
	public Result add(LanguageCandidate languageCandidate) {
		this.languageCandidateDao.save(languageCandidate);
		return new SuccessResult("Başarıyla Eklendi");
	}
	@Override
	public Result update(LanguageCandidate languageCandidate, int id) {
		var value = languageCandidateDao.getById(id);
		value.setLanguage(languageCandidate.getLanguage());
		value.setCandidate(languageCandidate.getCandidate());
		value.setLanguageLevel(languageCandidate.getLanguageLevel());
		languageCandidateDao.save(value);
		return new SuccessResult();
	}

}
