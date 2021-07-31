package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CVJobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CVJobExperienceDao;
import kodlama.io.hrms.entities.concretes.CVJobExperience;

@Service
public class CVJobExperienceManager implements  CVJobExperienceService {
	
	private CVJobExperienceDao cvJobExperienceDao;

	@Autowired
	public CVJobExperienceManager(CVJobExperienceDao cvJobExperienceDao) {
		super();
		this.cvJobExperienceDao = cvJobExperienceDao;
	}

	@Override
	public Result add(CVJobExperience cvJobExperience) {
		this.cvJobExperienceDao.save(cvJobExperience);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public DataResult<List<CVJobExperience>> getAllByJobSeekerIdOrderByLeaveYear(int jobSeekerId) {
		return new SuccessDataResult<List<CVJobExperience>>(this.cvJobExperienceDao.getAllByJobSeekerIdOrderByLeaveYear(jobSeekerId),"Adaylar tecrübeleri yıllara göre listelendi");
	}


	
	
	
}
