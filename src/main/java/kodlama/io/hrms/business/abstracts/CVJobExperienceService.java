
package kodlama.io.hrms.business.abstracts;


import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVJobExperience;


public interface CVJobExperienceService{
	
	Result add(CVJobExperience cvJobExperience);
	
	DataResult<List<CVJobExperience>> getAllByJobSeekerIdOrderByLeaveYear(int jobSeekerId);
}
