package kodlama.io.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CVImage;

public interface CVImageService {
	
	Result add(CVImage cvImage,MultipartFile multipartFile);
	
	DataResult<CVImage> getByJobSeekerId(int jobSeekerId);
}
