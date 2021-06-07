package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerService;
import kodlama.io.hrms.core.adapter.abstracts.EmailService;
import kodlama.io.hrms.core.adapter.abstracts.MernisService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobseekerService {

	private JobSeekerDao jobseekerDao;
	private MernisService mernisService;
	private EmailService emailService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobseekerDao, MernisService mernisService, EmailService emailService) {
		super();
		this.jobseekerDao=jobseekerDao;
		this.mernisService=mernisService;
		this.emailService=emailService;
	}
	
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobseekerDao.findAll(),"iş arayanlar listelendi.");
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		if(isNull(jobSeeker)) {
			return new ErrorResult("Her alan doldurulmalı!");
		}
		else if(!checkEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Email formatı doğru değil");
		}
		else if(doesEmailExist(jobSeeker)) {
			return new ErrorResult("Mail sistemde mevcut!");
		}
		else if(isNationalityIdExist(jobSeeker)) {
			return new ErrorResult("Kimlik numarası sistemde mevcut!");
		}
		else if(!mernisService.checkIfRealPerson(jobSeeker)) {
			return new ErrorResult("Gerçek kişi hatası!");
		}
		this.emailService.verify(jobSeeker.getEmail());
		this.jobseekerDao.save(jobSeeker);
		return new SuccessResult("Ekleme başarılı");
	}
	
	
	
	
	
	
	public boolean checkEmail(String email) {
		String emailPattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern =Pattern.compile(emailPattern,Pattern.CASE_INSENSITIVE);
	    boolean result= pattern.matcher(email).find();
	    if(result) {
	    	return true;
	    }
	   return false;
	}
	
	public boolean doesEmailExist(JobSeeker jobSeeker) {
		
		boolean result=false;
		if(jobseekerDao.findByEmail(jobSeeker.getEmail())!=null) {
			result=true;
		}
	
		return result;
	}
	public boolean isNationalityIdExist(JobSeeker jobSeeker) {
		boolean result=false;
		if(jobseekerDao.findByNationalityId(jobSeeker.getNationalityId())!=null) {
			result=true;
		}
		return result;
		
	}
	public boolean isNull(JobSeeker jobSeeker) {
		boolean result=false;
		if(jobSeeker.getNationalityId().isEmpty() || jobSeeker.getFirstName().isEmpty()
		   || jobSeeker.getLastName().isEmpty()|| jobSeeker.getDateofBirth() == null) {  
			
			result=true;
		}
		return result;
	}


	

}
