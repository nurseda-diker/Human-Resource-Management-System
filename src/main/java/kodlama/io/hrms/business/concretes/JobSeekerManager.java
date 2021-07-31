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
import kodlama.io.hrms.dataAccess.abstracts.CVEducationDao;
import kodlama.io.hrms.dataAccess.abstracts.CVImageDao;
import kodlama.io.hrms.dataAccess.abstracts.CVJobExperienceDao;
import kodlama.io.hrms.dataAccess.abstracts.CVLanguageDao;
import kodlama.io.hrms.dataAccess.abstracts.CVLinkDao;
import kodlama.io.hrms.dataAccess.abstracts.CVSkillDao;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.dtos.JobSeekerCVDto;



@Service
public class JobSeekerManager implements JobseekerService {

	private JobSeekerDao jobseekerDao;
	private MernisService mernisService;
	private EmailService emailService;
	private CVEducationDao cvEducationDao;
	private CVJobExperienceDao cvJobExperienceDao;
	private CVLanguageDao cvLanguageDao;
	private CVSkillDao cvSkillDao;
	private CVImageDao cvImageDao;
	private CVLinkDao cvLinkDao;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobseekerDao, MernisService mernisService, EmailService emailService,
			CVEducationDao cvEducationDao, CVJobExperienceDao cvJobExperienceDao, CVLanguageDao cvLanguageDao,
			CVSkillDao cvSkillDao, CVImageDao cvImageDao, CVLinkDao cvLinkDao) {
		super();
		this.jobseekerDao = jobseekerDao;
		this.mernisService = mernisService;
		this.emailService = emailService;
		this.cvEducationDao = cvEducationDao;
		this.cvJobExperienceDao = cvJobExperienceDao;
		this.cvLanguageDao = cvLanguageDao;
		this.cvSkillDao = cvSkillDao;
		this.cvImageDao = cvImageDao;
		this.cvLinkDao = cvLinkDao;
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
		if(jobseekerDao.getByEmail(jobSeeker.getEmail())!=null) {
			result=true;
		}
	
		return result;
	}
	public boolean isNationalityIdExist(JobSeeker jobSeeker) {
		boolean result=false;
		if(jobseekerDao.getByNationalityId(jobSeeker.getNationalityId())!=null) {
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


	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobseekerDao.getOne(id));
	}


	@Override
	public DataResult<JobSeeker> getByNationalityId(String nationalityId) {
		return new SuccessDataResult<JobSeeker>(this.jobseekerDao.getByNationalityId(nationalityId));
	}


	@Override
	public DataResult<JobSeekerCVDto> getCVById(int id) {
		JobSeekerCVDto jobSeekercvDto=new JobSeekerCVDto();
		jobSeekercvDto.setJobSeeker(this.jobseekerDao.getOne(id));
		jobSeekercvDto.setCvEducation(this.cvEducationDao.getAllByJobSeeker_Id(id));
		jobSeekercvDto.setCvJobExperience(this.cvJobExperienceDao.getAllByJobSeeker_Id(id));
		jobSeekercvDto.setCvLanguage(this.cvLanguageDao.getAllByJobSeeker_Id(id));
		jobSeekercvDto.setCvLink(this.cvLinkDao.getAllByJobSeeker_Id(id));
		jobSeekercvDto.setCvImage(this.cvImageDao.getByJobSeeker_Id(id));
		jobSeekercvDto.setCvSkill(this.cvSkillDao.getAllByJobSeeker_Id(id));
		return new SuccessDataResult<JobSeekerCVDto>(jobSeekercvDto);
	}


	

}
