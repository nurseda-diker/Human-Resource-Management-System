package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CVEducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CVEducationDao;
import kodlama.io.hrms.entities.concretes.CVEducation;

@Service
public class CVEducationManager implements CVEducationService {

	private CVEducationDao cvEducationDao;
	
	@Autowired
	public CVEducationManager(CVEducationDao cvEducationDao) {
		super();
		this.cvEducationDao = cvEducationDao;
	}

	@Override
	public Result add(CVEducation cvEducation) {
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("Ekleme başarılı.");
		
	}

	@Override
	public DataResult<List<CVEducation>> getAllByJobSeekerIdOrderByGraduationYear(int jobSeekerId) {
		return new SuccessDataResult<List<CVEducation>>(this.cvEducationDao.getAllByJobSeeker_Id(jobSeekerId),"Adaylar mezuniyet yılına göre sıralandı." );
	}

}
