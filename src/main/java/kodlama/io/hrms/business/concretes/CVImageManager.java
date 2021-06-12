package kodlama.io.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.CVImageService;
import kodlama.io.hrms.core.image.abstracts.CloudinaryService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CVImageDao;
import kodlama.io.hrms.entities.concretes.CVImage;

@Service
public class CVImageManager implements CVImageService {
	
	private CVImageDao cvImageDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public CVImageManager(CVImageDao cvImageDao,CloudinaryService cloudinaryService) {
		super();
		this.cvImageDao = cvImageDao;
		this.cloudinaryService=cloudinaryService;
	}

	@Override
	public Result add(CVImage cvImage,MultipartFile multipartFile) {
		Map<String,String> addedImage =  (Map<String, String>) cloudinaryService.save(multipartFile).getData();
		cvImage.setUrl(addedImage.get("url"));
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public DataResult<CVImage> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<CVImage>(this.cvImageDao.getByJobSeeker_Id(jobSeekerId));
	}
	
	
	
}
