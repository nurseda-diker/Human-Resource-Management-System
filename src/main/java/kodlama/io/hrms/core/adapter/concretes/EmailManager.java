package kodlama.io.hrms.core.adapter.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.adapter.abstracts.EmailService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;

@Service
public class EmailManager implements EmailService{

	private UserDao userDao;
	
	public EmailManager(UserDao userDao) {
		super();
		this.userDao=userDao;
	}
	

	@Override
	public Result sendMail(String email, String message) {
		return new SuccessDataResult("Mail gönderildi.");
		
	}

	@Override
	public boolean verify(String email) {
		return true;
	}

}
