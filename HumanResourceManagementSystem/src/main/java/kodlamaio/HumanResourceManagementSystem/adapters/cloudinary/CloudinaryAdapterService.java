package kodlamaio.HumanResourceManagementSystem.adapters.cloudinary;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.HumanResourceManagementSystem.core.helpers.PhotoUploadHelper;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.ErrorDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
@Service
public class CloudinaryAdapterService implements PhotoUploadHelper {

	 private Cloudinary cloudinary;
	    
	    private Map<String, String> valuesMap = new HashMap<>();

	    	public CloudinaryAdapterService() {
	    		valuesMap.put("cloud_name","esracbs" );
	    		valuesMap.put("api_key", "256371848233192" );
	    		valuesMap.put("api_secret","hHogyJeKGxTFYCvFtTYstwAdF74" );
	    		cloudinary = new Cloudinary(valuesMap);
	    	}
	    	
	    	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
	    		File file;
				try {
					file = convert(multipartFile);
		    		Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		    		file.delete();
		    		return new SuccessDataResult<Map<String, String>>(result);
				} catch (IOException e) {
					e.printStackTrace();
					return new ErrorDataResult<Map<String, String>>("Dosya yüklenemedi");
				}
	    	}
	    	
	    	public DataResult<Map> delete (String id) throws IOException {
	    		Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
	    		return new SuccessDataResult<Map>(result);
	    	}
	    	
	    	
	    	private File convert(MultipartFile multipartFile) throws IOException {
	    		File file = new File(multipartFile.getOriginalFilename());
	    		FileOutputStream stream = new FileOutputStream(file);
	    		stream.write(multipartFile.getBytes());
	    		stream.close();
	    		
	    		return file;
	    	}
}
