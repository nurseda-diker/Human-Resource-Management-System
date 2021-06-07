package kodlama.io.hrms.entities.concretes;



import java.util.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;


import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="job_definition")
	private String jobDefinition;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@NotBlank(message="Bu kısım boş geçilemez!")
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="created_date")
	private LocalDate createdDate=LocalDate.now();
	
	@NotBlank(message="Bu kısım boş geçilemez!")
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
	
	
}
