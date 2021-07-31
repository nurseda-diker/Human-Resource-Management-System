package kodlama.io.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForRegisterDto {
	
	private String firstName;
	private String lastName;
	private String nationalityId;
	private Date dateofBirth;
	private String email;
	private String password;
	private String verifyPassword;
	
	
	
}
