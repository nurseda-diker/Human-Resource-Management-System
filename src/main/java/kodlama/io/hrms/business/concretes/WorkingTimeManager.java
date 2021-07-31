package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.WorkingTimeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlama.io.hrms.entities.concretes.WorkingTime;


@Service
public class WorkingTimeManager implements WorkingTimeService{

	WorkingTimeDao workingTimeDao;
	
	
	
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		this.workingTimeDao = workingTimeDao;
	}



	@Override
	public DataResult<List<WorkingTime>> getAll() {
		
		return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll());
	}

}
