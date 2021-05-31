package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobSeekers;

public interface JobseekerService {
	
	DataResult<List<JobSeekers>> getAll();
}
