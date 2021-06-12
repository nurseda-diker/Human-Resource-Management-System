package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CVLinkService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CVLinkDao;
import kodlama.io.hrms.entities.concretes.CVLink;

@Service
public class CVLinkManager implements CVLinkService{
	
	private CVLinkDao cvLinkDao;

	@Autowired
	public CVLinkManager(CVLinkDao cvLinkDao) {
		super();
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(CVLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Ekleme başarılı");
	}
	
	
	
	
}
