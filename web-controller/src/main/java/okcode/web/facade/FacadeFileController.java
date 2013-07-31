//package okcode.web.facade;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import okcode.biz.trading.util.GlobalConstants;
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.web.base.BaseController;
//
//
///**
// * @author Administrator
// * 
// */
//@Controller
//@RequestMapping(value = "/siteFile")
//public class FacadeFileController extends BaseController {
//	
//	@RequestMapping(value = "/uf/{userId}/{storeName}.{suffixName}", method = RequestMethod.GET)
//	@ResponseBody
//	public byte[] get(HttpServletRequest request,
//			HttpServletResponse response,
//			@PathVariable("userId") String userId,
//			@PathVariable("storeName") String storeName,
//			@PathVariable("suffixName") String suffixName) {
//		File file = new File(GlobalConstants.FILESTORE_BASEPATH
//				+ File.separator
//				+ userId
//				+ File.separator + storeName);
//		byte[] b = null;
//		try {
//			b = FileCopyUtils.copyToByteArray(file);
//		} catch (IOException e) {
//			throw new AppException(ErrorCode.SERVER_ERROR);
//		}
//		return b;
//	}
//}
