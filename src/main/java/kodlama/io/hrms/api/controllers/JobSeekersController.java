package kodlama.io.hrms.api.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.dtos.JobSeekerCVDto;

@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekersController {

	private JobseekerService jobSeekerService;
	
	@Autowired
	public JobSeekersController(JobseekerService jobseekerService) {
		super();
		this.jobSeekerService=jobseekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
	
	@GetMapping("/getById")
	public DataResult<JobSeeker> getById(@RequestParam int id){
		return this.jobSeekerService.getById(id);
	}
	
	@GetMapping("/getByNationalityId")
	public DataResult<JobSeeker> getByNationalityId(@RequestParam String nationalityId){
		return this.jobSeekerService.getByNationalityId(nationalityId);
	}
	
	@GetMapping("/getCVById")
	public DataResult<JobSeekerCVDto> getCVById(@RequestParam int id){
		return this.jobSeekerService.getCVById(id);
	}
	
	
	
	
}
