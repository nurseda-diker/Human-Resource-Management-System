package kodlama.io.hrms.core.image.abstracts;



import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	
	DataResult<?> save(MultipartFile file);
}
