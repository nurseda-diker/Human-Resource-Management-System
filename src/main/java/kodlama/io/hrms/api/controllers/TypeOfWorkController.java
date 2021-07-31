package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.TypeOfWorkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.TypeOfWork;

@RestController
@RequestMapping("/api/TypeOfWork")
@CrossOrigin
public class TypeOfWorkController {

	TypeOfWorkService typeOfWorkService;

	public TypeOfWorkController(TypeOfWorkService typeOfWorkService) {
		this.typeOfWorkService = typeOfWorkService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<TypeOfWork>> getAll(){
		return typeOfWorkService.getAll();
	}
	
	
	
}
