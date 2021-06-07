package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_position")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
@Data
public class Job {
	
	@Id
	@GeneratedValue //id bir bir artıyor
	@Column(name="jobtitle_id")
	private int id;
	
	@Column(name="position_name")
	private String positionName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "job")
	private List<JobPosting> jobPostings;
	
	
	
	
	
	
	
	
}
