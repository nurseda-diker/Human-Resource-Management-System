package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVEducation;

public interface CVEducationService {
	
	Result add(CVEducation cvEducation);
	DataResult<List<CVEducation>> getAllByJobSeekerIdOrderByGraduationYear(int jobSeekerId);
	
}
