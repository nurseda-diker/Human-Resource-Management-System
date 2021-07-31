package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.adapter.abstracts.EmailService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailService emailService) {
		super();
		this.employerDao=employerDao;
		this.emailService=emailService;
		
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Şirketler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if(isNull(employer)) {
			return new ErrorDataResult<Employer>("Bütün alanlar doldurulmalı!");
		}
		else if(employerDao.getByEmail(employer.getEmail()).stream().count() !=0) {
			return new ErrorDataResult<Employer>("Mail sistemde mevcut!");
		}
		else if(!isSameDomain(employer)) {
			return new ErrorDataResult<Employer>("Girilen mail adresi uygun değil!");
		}
		this.emailService.verify(employer.getEmail());
		this.employerDao.save(employer);
		return new SuccessDataResult<Employer>("Şirket eklendi");
	}
	
	public boolean isNull(Employer employer) {
		boolean result=false;
		
		if(employer.getCompanyName().isEmpty()||employer.getWebSite().isEmpty()||
		   employer.getPassword().isEmpty()|| employer.getPhoneNumber().isEmpty()) {
			
			result=true;
		}
		
		return result;
	}
	
	
	public boolean isMailExist(Employer employer) {
		boolean result=false;
		
		if(employerDao.getByEmail(employer.getEmail())!=null) {
			result=true;
		}
		
		return result;
	}
	public boolean isSameDomain(Employer employer) {
		
		/*boolean result=false;
		
		String email=employer.getEmail();
		String[] emailSplit = email.split("@");
		
		if(!emailSplit[1].equals(employer.getWebSite())) {
			result=true;
		}
		
		return result;*/
		
		String email = employer.getEmail();
        String[] emailSplit = email.split("@");
        if(!emailSplit[1].equals(employer.getWebSite())) {
            return true;
        }
        return false;
	}
	
   
   

	
	
	
	
	
	

}
