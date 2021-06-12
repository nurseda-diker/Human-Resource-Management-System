package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.dtos.JobSeekerCVDto;

public interface JobseekerService {
	
	Result add(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();

	DataResult<JobSeeker> getById(int id);
	
	DataResult<JobSeeker> getByNationalityId(String nationalityId);

	DataResult<JobSeekerCVDto> getCVById(int id);
}

