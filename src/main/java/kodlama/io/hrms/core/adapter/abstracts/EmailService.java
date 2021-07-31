package kodlama.io.hrms.core.adapter.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;


public interface EmailService {
	
	boolean verify(String email);
	
	Result sendMail(String email,String message);
	
	
}
