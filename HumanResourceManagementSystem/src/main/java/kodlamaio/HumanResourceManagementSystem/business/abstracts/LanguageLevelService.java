package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import java.util.List;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageLevel;

public interface LanguageLevelService {
	DataResult<List<LanguageLevel>> getAll();
	Result add(LanguageLevel languageLevel);
}
