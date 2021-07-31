package kodlama.io.hrms.entities.concretes;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_postings")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="job_definition")
	private String jobDefinition;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="min_salary")
	private double minSalary;
	
	//@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	//@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="numberof_open_position")
	private int countOpenPosition;
	
	@ManyToOne
	@JoinColumn(name="jobtitle_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="working_time_id")
	private WorkingTime workingTime;
	
	@ManyToOne
	@JoinColumn(name="working_type_id")
	private TypeOfWork typeOfWork;
	
	
}
