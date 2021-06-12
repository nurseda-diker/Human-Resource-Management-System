package kodlama.io.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPostingService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPostingDao;
import kodlama.io.hrms.entities.concretes.JobPosting;


@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao=jobPostingDao;
	}
	
	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"Tüm iş ilanları listelendi");
	}

	

	@Override
	public DataResult<List<JobPosting>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByIsActive(isActive),"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByIsActiveOrderByApplicationDeadline(boolean isActive) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByIsActiveOrderByApplicationDeadline(isActive));
	}

	@Override
	public DataResult<List<JobPosting>> getByIsActiveEmployer_CompanyName(boolean isActive, String company_name) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByIsActiveAndEmployer_CompanyName(isActive, company_name), company_name);
	}

	

	

}
