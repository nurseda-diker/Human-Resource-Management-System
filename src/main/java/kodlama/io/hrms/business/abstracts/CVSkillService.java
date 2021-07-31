package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVSkill;

public interface CVSkillService {
	
	Result add(CVSkill cvSkill);
}
