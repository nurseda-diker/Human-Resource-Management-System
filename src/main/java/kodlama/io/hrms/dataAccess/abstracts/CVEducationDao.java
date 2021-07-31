package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CVEducation;

public interface CVEducationDao extends JpaRepository<CVEducation, Integer>{

	List<CVEducation> getAllByJobSeeker_Id(int jobSeekerId);
	
	List<CVEducation> getAllByJobSeekerIdOrderByGraduationYear(int jobSeekerId);
	
}
