package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CVJobExperience;

public interface CVJobExperienceDao extends JpaRepository<CVJobExperience, Integer> {

	List<CVJobExperience> getAllByJobSeeker_Id(int jobSeekerId);
	
	List<CVJobExperience> getAllByJobSeekerIdOrderByLeaveYear(int jobSeekerId);
}
