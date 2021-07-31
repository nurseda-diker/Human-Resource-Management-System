package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CVLinkService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVLink;

@RestController
@RequestMapping("/api/cvLink")
public class CVLinksController {
	
	private CVLinkService cvLinkService;

	@Autowired
	public CVLinksController(CVLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVLink cvLink) {
		return this.cvLinkService.add(cvLink);
	}
	
	
	
	
}
