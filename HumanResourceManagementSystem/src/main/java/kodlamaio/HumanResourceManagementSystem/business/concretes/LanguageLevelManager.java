package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageCandidateService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageLevelService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.LanguageCandidateDao;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.LanguageLevelDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageLevel;

@Service
public class LanguageLevelManager implements LanguageLevelService{
	@Autowired
	private LanguageLevelDao languageLevelDao;
	
	public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
		super();
		this.languageLevelDao = languageLevelDao;
	}

	@Override
	public DataResult<List<LanguageLevel>> getAll() {
		return new SuccessDataResult<List<LanguageLevel>>(this.languageLevelDao.findAll());
	}

	@Override
	public Result add(LanguageLevel languageLevel) {
		this.languageLevelDao.save(languageLevel);
		return new SuccessResult("Başarıyla Eklendi");
	}
}
