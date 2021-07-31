package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.CVImageService;
import kodlama.io.hrms.business.abstracts.JobseekerService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVImage;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/cvImage")
public class CVImagesController {
	
	private CVImageService cvImageService;
	private JobseekerService jobSeekerService;

	@Autowired
	public CVImagesController(CVImageService cvImageService,JobseekerService jobSeekerService) {
		super();
		this.cvImageService = cvImageService;
		this.jobSeekerService=jobSeekerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int jobseekerId, @RequestBody MultipartFile multipartFile) {
		JobSeeker jobSeeker=this.jobSeekerService.getById(jobseekerId).getData();	
		CVImage addedImage=new CVImage();
		addedImage.setJobSeeker(jobSeeker);
		return this.cvImageService.add(addedImage, multipartFile);
	
	}
	
}
