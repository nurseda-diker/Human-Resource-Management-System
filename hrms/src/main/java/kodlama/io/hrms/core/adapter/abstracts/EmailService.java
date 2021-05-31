package kodlama.io.hrms.core.adapter.abstracts;

import kodlama.io.hrms.entities.concretes.Users;

public interface EmailService {
	
	boolean verify(Users user);
	
	void sendMail(String email,String message);
	
	
}
