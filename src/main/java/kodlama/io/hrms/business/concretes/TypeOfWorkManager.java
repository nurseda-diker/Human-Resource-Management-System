package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.TypeOfWorkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.TypeOfWorkDao;
import kodlama.io.hrms.entities.concretes.TypeOfWork;

@Service
public class TypeOfWorkManager implements TypeOfWorkService {
	
	TypeOfWorkDao typeOfWorkDao;
	
	@Autowired
	public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
		this.typeOfWorkDao = typeOfWorkDao;
	}


	@Override
	public DataResult<List<TypeOfWork>> getAll() {
		return new SuccessDataResult<List<TypeOfWork>>(typeOfWorkDao.findAll());
	}

}
