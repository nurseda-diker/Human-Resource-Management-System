package kodlama.io.hrms.entities.dtos;

import java.util.List;

import kodlama.io.hrms.entities.concretes.CVEducation;
import kodlama.io.hrms.entities.concretes.CVImage;
import kodlama.io.hrms.entities.concretes.CVJobExperience;
import kodlama.io.hrms.entities.concretes.CVLanguage;
import kodlama.io.hrms.entities.concretes.CVLink;
import kodlama.io.hrms.entities.concretes.CVSkill;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCVDto {
	
	private JobSeeker jobSeeker;
	private List<CVEducation> cvEducation;
	private List<CVJobExperience> cvJobExperience;
	private List<CVLanguage> cvLanguage;
	private List<CVLink> cvLink;
	private List<CVSkill> cvSkill;
	private CVImage cvImage;
	
	
	
	
}
