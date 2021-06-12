package kodlama.io.hrms.business.abstracts;


import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	Result add(JobPosting jobPosting);
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getByIsActive(boolean isActive);
	DataResult<List<JobPosting>> getByIsActiveOrderByApplicationDeadline(boolean isActive);
	DataResult<List<JobPosting>> getByIsActiveEmployer_CompanyName(boolean isActive,String company_name);
	
	
}
