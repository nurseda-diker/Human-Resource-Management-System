package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobPosting;
import kodlama.io.hrms.entities.dtos.JobPostingDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	
	List<JobPosting> getByIsActive(boolean isActive);
	
	
	
	List<JobPosting> getByIsActiveOrderByApplicationDeadline(boolean isActive);
	
	
	
	List<JobPosting> getByIsActiveAndEmployer_CompanyName(boolean isActive,String company_name);
	
	
	JobPosting getById(int id);
	
	
}
