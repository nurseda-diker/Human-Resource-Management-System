package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CVSkillService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVSkill;

@RestController
@RequestMapping("/api/cvSkill")
public class CVSkillsController {
	
	private CVSkillService cvSkillService;

	@Autowired
	public CVSkillsController(CVSkillService cvSkillService) {
		super();
		this.cvSkillService = cvSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVSkill cvSkill) {
		return this.cvSkillService.add(cvSkill);
	}
	
	
	
}
