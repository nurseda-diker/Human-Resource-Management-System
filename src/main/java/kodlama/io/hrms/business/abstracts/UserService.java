package kodlama.io.hrms.business.abstracts;



import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.User;


public interface UserService {
	
	DataResult<User> getByEmail(String email);
}
