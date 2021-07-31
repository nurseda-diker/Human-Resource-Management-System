package kodlama.io.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingForAddDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_definition")
	private String jobDefinition;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="count_open_position")
	private int countOpenPosition;
	
	@Column(name="application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="job_title_id")
	private int jobTitleId;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="working_time_id")
	private int workingTimeId;
	
	@Column(name="working_type_id")
	private int workingTypeId;
	
	
	
}
