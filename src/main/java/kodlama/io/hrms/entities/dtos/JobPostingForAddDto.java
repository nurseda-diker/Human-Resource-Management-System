package kodlama.io.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingForAddDto {

	private String jobDefinition;
	private double minSalary;
	private double maxSalary;
	private int countOpenPosition;
	private Date applicationDeadline;
	private Date createDate;
	private boolean isActive;
	private int cityId;
	private int jobTitleId;
	private int employerId;
	
	
	
}
