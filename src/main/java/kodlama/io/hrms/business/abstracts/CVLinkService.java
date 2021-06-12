package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVLink;

public interface CVLinkService {
	
	Result add(CVLink cvLink);
}
