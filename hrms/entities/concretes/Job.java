package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="job_position")


@Data
public class Job {
	
	@Id
	@GeneratedValue //id bir bir artıyor
	@Column(name="id")
	private int id;
	
	@Column(name="position_name")
	private String position_name;
	
	
	public Job() {
		
	}
	
	public Job(int id, String position_name) {
		super();
		this.id = id;
		this.position_name = position_name;
	}
	
	
	
	
	
	
}
