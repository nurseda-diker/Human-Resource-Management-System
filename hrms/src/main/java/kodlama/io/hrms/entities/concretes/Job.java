package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_position")


@Data
public class Job {
	
	@Id
	@GeneratedValue //id bir bir artıyor
	@Column(name="id")
	private int id;
	
	@Column(name="position_name")
	private String position_name;
	
	
	
	
	
	
	
	
	
	
	
}
