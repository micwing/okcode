//package okcode.web.console.sysconfig;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Collections;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import okcode.biz.trading.util.GlobalConstants;
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.result.Result;
//import okcode.service.standard.intf.FileStoreService;
//import okcode.web.base.BaseController;
//
///**
// * 门户商品请求controller
// * 
// * @author Administrator
// * 
// */
//@Controller
//@RequestMapping(value = "/console/file")
//public class FileController extends BaseController {
//	@Autowired
//	private FileStoreService fileStoreService;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView index() {
//		ModelAndView mav = new ModelAndView(CONSOLE + "file/index");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doDelete(Long fileStoreId) {
//		fileStoreService.delete(Collections.singleton(fileStoreId));
//		return new Result();
//	}
//
////	@RequestMapping(value = "/uf/{userId}/{storeName}.{suffixName}", method = RequestMethod.GET)
////	@ResponseBody
////	public byte[] get(HttpServletRequest request,
////			HttpServletResponse response,
////			@PathVariable("userId") String userId,
////			@PathVariable("storeName") String storeName,
////			@PathVariable("suffixName") String suffixName) {
////		File file = new File(GlobalConstants.FILESTORE_BASEPATH
////				+ File.separator
////				+ userId
////				+ File.separator + storeName);
////		byte[] b = null;
////		try {
////			b = FileCopyUtils.copyToByteArray(file);
////		} catch (IOException e) {
////			throw new AppException(ErrorCode.SERVER_ERROR);
////		}
////		return b;
////	}
//	
////	@RequestMapping(value = "/bo/{biz}/{owner}", method = RequestMethod.GET)
////	@ResponseBody
////	public byte[] get(HttpServletRequest request,
////			HttpServletResponse response,
////			@PathVariable String biz,
////			@PathVariable String owner) {
////		FileStore info = fileStoreService.find(storeName);
////		File file = new File(info.getStorePath()
////				+ File.separator + info.getStoreName());
////		return FileCopyUtils.copyToByteArray(file);
////	}
//
//}
