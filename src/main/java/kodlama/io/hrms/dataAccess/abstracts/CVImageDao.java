package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CVImage;

public interface CVImageDao extends JpaRepository<CVImage, Integer>{
	
	CVImage getByJobSeeker_Id(int jobSeekerId);
}
