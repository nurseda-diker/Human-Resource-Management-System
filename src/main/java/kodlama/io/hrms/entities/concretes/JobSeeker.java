package kodlama.io.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="jobSeekers")
//@PrimaryKeyJoinColumn(name="jobSeekerId",referencedColumnName = "id")


public class JobSeeker extends User{

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="date_of_birth")
	private LocalDate dateofBirth;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CVEducation> cvEducation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CVJobExperience> cvjobExperience;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CVLanguage> cvLanguage;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jobSeeker")
	private CVImage cvImage;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CVLink> cvLink;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CVSkill> cvSkill;
	
	
	


	
	
	
	
	
	
	
}
