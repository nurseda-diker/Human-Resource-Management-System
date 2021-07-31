package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)


public class User {
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message="Email alanı boş bırakılamaz!")
	@Column(name="email")
	private String email;
	
	@NotBlank(message="Şifre alanı boş bırakılamaz!")
	@Column(name="password")
	private String password;
	
	private String repeatPassword;
	
	
	
	
	
	
}
