package kodlamaio.HumanResourceManagementSystem.core.helpers;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;


public interface PhotoUploadHelper {
	DataResult<Map<String, String>> upload(MultipartFile file);
	DataResult<Map> delete(String id) throws IOException;
}
