package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CVLanguageService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CVLanguageDao;
import kodlama.io.hrms.entities.concretes.CVLanguage;

@Service
public class CVLanguageManager implements CVLanguageService{
	
	private CVLanguageDao cvLanguageDao;

	@Autowired
	public CVLanguageManager(CVLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(CVLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Ekleme başarılı");
	}
	
	
	
}
