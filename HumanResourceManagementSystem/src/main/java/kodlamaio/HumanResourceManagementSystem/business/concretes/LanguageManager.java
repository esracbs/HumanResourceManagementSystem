package kodlamaio.HumanResourceManagementSystem.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts.LanguageDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Language;
@Service
public class LanguageManager implements LanguageService{
	private LanguageDao languageDao;

	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());

	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Başarıyla Eklendi");
	}
	
}
