package kodlama.io.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPostingService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobPosting")
public class JobPostingsController {
	
	private JobPostingService jobPostingService;
	
	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService=jobPostingService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobPosting>> getByIsActive(boolean isActive){
		return this.jobPostingService.getByIsActive(true);
	}
	
	@GetMapping("/getByIsActiveOrderByApplicationDeadline")
	public DataResult<List<JobPosting>> getByIsActiveOrderByApplicationDeadline(boolean isActive){
		return this.jobPostingService.getByIsActiveOrderByApplicationDeadline(true);
	}
	
	@GetMapping("/getByIsActiveEmployer_CompanyName")
	public DataResult<List<JobPosting>> getByIsActiveEmployer_Company(boolean isActive,String company_name){
		return this.jobPostingService.getByIsActiveEmployer_CompanyName(true, company_name);
	}
	
	
	
}
