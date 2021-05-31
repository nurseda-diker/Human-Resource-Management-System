package kodlama.io.hrms.core.adapter.abstracts;

import kodlama.io.hrms.entities.concretes.JobSeekers;

public interface UserCheckService {
	
	boolean checkIfRealPerson(JobSeekers jobSeeker);
}
