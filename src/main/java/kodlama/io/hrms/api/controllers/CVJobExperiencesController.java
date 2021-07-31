package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CVJobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVJobExperience;

@RestController
@RequestMapping("/api/cvJobExperience")
public class CVJobExperiencesController {
	
	private CVJobExperienceService cvJobExperienceService;

	@Autowired
	public CVJobExperiencesController(CVJobExperienceService cvJobExperienceService) {
		super();
		this.cvJobExperienceService = cvJobExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVJobExperience cvJobExperience) {
		return this.cvJobExperienceService.add(cvJobExperience);
	}
	
	@GetMapping("/getAllByJobSeekerIdOrderByLeaveYear")
	public DataResult<List<CVJobExperience>>getAllByJobSeekerIdOrderByLeaveYear (int jobSeekerId){
		return this.cvJobExperienceService.getAllByJobSeekerIdOrderByLeaveYear(jobSeekerId);
	}
	
	
	
	
}
