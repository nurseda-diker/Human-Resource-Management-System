package kodlama.io.hrms.core.adapter.abstracts;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface MernisService {
	
	boolean checkIfRealPerson(JobSeeker jobSeeker);
}
