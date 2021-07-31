package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CVLanguageService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVLanguage;

@RestController
@RequestMapping("/api/cvLanguage")
public class CVLanguageController {
	
	private CVLanguageService cvLanguageService;

	@Autowired
	public CVLanguageController(CVLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVLanguage cvLanguage) {
		return this.cvLanguageService.add(cvLanguage);
				
	}
	
	
}
