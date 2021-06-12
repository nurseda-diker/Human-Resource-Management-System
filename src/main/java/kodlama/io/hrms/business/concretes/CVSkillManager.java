package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CVSkillService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CVSkillDao;
import kodlama.io.hrms.entities.concretes.CVSkill;

@Service
public class CVSkillManager implements CVSkillService{
	
	private CVSkillDao cvSkillDao;

	@Autowired
	public CVSkillManager(CVSkillDao cvSkillDao) {
		super();
		this.cvSkillDao = cvSkillDao;
	}

	@Override
	public Result add(CVSkill cvSkill) {
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("Ekleme başarılı");
	}
	
	
}
