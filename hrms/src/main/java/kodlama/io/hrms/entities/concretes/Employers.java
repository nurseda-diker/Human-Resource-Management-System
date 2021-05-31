package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id")

public class Employers extends Users{
	
	
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	
	
	
	
	
	
	
	
	
	
}
