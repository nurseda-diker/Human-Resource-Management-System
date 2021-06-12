package kodlama.io.hrms.core.image.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.image.abstracts.CloudinaryService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {
	
	private  Cloudinary cloudinary;
	
	public CloudinaryManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","dupypq8ju",
				"api_key", "784411468984379",
				"api_secret","ZscfhcVXR3dwU9Wznna56nMfPT0"));
	}

	@Override
	public DataResult<?> save(MultipartFile file) {
		try {
			Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), 
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(cloudinaryUploader);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

	
	

	
}
