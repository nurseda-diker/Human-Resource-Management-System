package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CVEducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVEducation;

@RestController
@RequestMapping("/api/cvEducation")
public class CVEducationsController {
	
	private CVEducationService cvEducationService;

	@Autowired
	public CVEducationsController(CVEducationService cvEducationService) {
		super();
		this.cvEducationService = cvEducationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVEducation cvEducation) {
		return this.cvEducationService.add(cvEducation);
	}
	
	@GetMapping("/getAllByJobSeekerIdOrderByGraduationYear")
	public DataResult<List<CVEducation>> getAllByJobSeekerIdOrderByGraduationYear (int jobSeekerId){
		return this.cvEducationService.getAllByJobSeekerIdOrderByGraduationYear(jobSeekerId);
	}
	
	
	
	
	
}
