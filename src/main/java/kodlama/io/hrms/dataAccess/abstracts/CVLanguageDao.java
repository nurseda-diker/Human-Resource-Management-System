package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CVLanguage;

public interface CVLanguageDao extends JpaRepository<CVLanguage, Integer>{
	
	List<CVLanguage> getAllByJobSeeker_Id(int jobSeekerId);
}
