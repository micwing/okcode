package okcode.web.portal.home;

import java.io.File;
import java.io.IOException;

import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.web.base.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ckfinder.connector.configuration.ConfigurationFactory;

/**
 * 平台门户请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/portal/upload")
public class PortalUploadController extends BaseController {
	
	@RequestMapping(value = "/{path}/{fileName}.{suffixName}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] index(@PathVariable String path,
			@PathVariable String fileName, @PathVariable String suffixName) {
		String basePath = "";
		try {
			basePath = ConfigurationFactory.getInstace().getConfiguration().getBaseDir();
		} catch (Exception e1) {
			throw new AppException(ErrorCode.SERVER_ERROR);
		}
		String filePath = basePath+File.separator+path+File.separator;
		File file = new File(filePath + fileName + "." + suffixName);
		byte[] b = null;
		try {
			b = FileCopyUtils.copyToByteArray(file);
		} catch (IOException e) {
			throw new AppException(ErrorCode.SERVER_ERROR);
		}
		return b;
	}
	
	@RequestMapping(value = "/_thumbs/Image/{fileName}.{suffixName}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] index(@PathVariable String fileName, @PathVariable String suffixName) {
		String basePath = "";
		try {
			basePath = ConfigurationFactory.getInstace().getConfiguration().getBaseDir();
		} catch (Exception e1) {
			throw new AppException(ErrorCode.SERVER_ERROR);
		}
		String filePath = basePath+File.separator+"_thumbs"+File.separator+"Images"+File.separator;
		File file = new File(filePath + fileName + "." + suffixName);
		byte[] b = null;
		try {
			b = FileCopyUtils.copyToByteArray(file);
		} catch (IOException e) {
			throw new AppException(ErrorCode.SERVER_ERROR);
		}
		return b;
	}
	
}
