package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobDao;
import kodlama.io.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}


	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"İş pozisyonları listelendi");
	}


	
	
	
	@Override
	public Result add(Job job) {
		if(job.getPositionName().isEmpty()) {
			return new ErrorResult("İş pozisyon alanı boş bırakılamaz.");
		}
	
		else if(this.jobDao.findBypositionName(job.getPositionName()).stream().count() !=0) {
			return new ErrorResult("Girilen pozisyon sistemde mevcut");
		}
		
		this.jobDao.save(job);
		return new SuccessResult("Ekleme başarılı.");
		
		
	}
	
	


	
	
	
	
	
	
	
}
