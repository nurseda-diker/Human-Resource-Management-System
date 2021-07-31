package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.WorkingTimeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/WorkingTime")
@CrossOrigin

public class WorkingTimeController {

	WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimeController(WorkingTimeService workingTimeService) {
		this.workingTimeService = workingTimeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingTime>> getAll(){
		return workingTimeService.getAll();
	}
	
	
	
}
