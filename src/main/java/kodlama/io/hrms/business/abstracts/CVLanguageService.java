package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVLanguage;

public interface CVLanguageService {
	
	Result add(CVLanguage cvLanguage);
}
