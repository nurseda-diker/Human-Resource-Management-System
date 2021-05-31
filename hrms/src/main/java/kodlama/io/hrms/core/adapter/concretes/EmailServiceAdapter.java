package kodlama.io.hrms.core.adapter.concretes;

import kodlama.io.hrms.core.adapter.abstracts.EmailService;
import kodlama.io.hrms.entities.concretes.Users;

public class EmailServiceAdapter implements EmailService{

	

	@Override
	public void sendMail(String email, String message) {
		System.out.println(email + "adresine" + message + "gönderildi.");
		
	}

	@Override
	public boolean verify(Users user) {
		return true;
	}

}
