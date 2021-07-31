package kodlama.io.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
	
	
	private String jobDefinition;
	private double maxSalary;
	private double minSalary;
	private int countOpenPosition;
	private LocalDateTime applicationDeadline;
	private LocalDateTime createDate;
	private int cityId;
	private int jobTitleId;
	private int employerId;
	private boolean isActive;
	private String workingTime;
	private String workingType;
	
}
