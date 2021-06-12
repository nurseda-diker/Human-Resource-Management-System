package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CVSkill;

public interface CVSkillDao extends JpaRepository<CVSkill, Integer>{
	
	List<CVSkill> getAllByJobSeeker_Id(int jobSeekerId);
	
	
}
