package okcode.web.portal.home;
//package okcode.web.portal;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.result.Result;
//import okcode.framework.web.ImageValidateCodeServlet;
//import okcode.service.standard.enums.UserGroup;
//import okcode.service.standard.intf.UserService;
//import okcode.service.standard.model.User;
//import okcode.web.base.BaseController;
//
//
///**
// * 注册Controller
// * 
// * @author MICHAEL
// */
//@Controller
//@RequestMapping(value = "/signup")
//public class SignupController extends BaseController {
//	
//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String index(ModelMap modelMap) {
//		if (getCurrentUser() != null)
//			return "redirect:/signin/redirect";
//		return PORTAL+"signup/index";
//	}
//
//	@RequestMapping(value = "/doSignup", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doSignup(HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestParam("username") String credential,
//			@RequestParam("password") String password ) {
//		//验证码
//		boolean paptchaFlag = ImageValidateCodeServlet.validate(request);
//		if (!paptchaFlag)
//			return new Result(ErrorCode.PAPTCHA_NOT_MATCH);
//		
//		User params = new User();
//		params.setUserName(credential);
//		params.setNickName(credential);
//		userService.addUser(credential, password, UserGroup.USER);
//		
//		return new Result(ErrorCode.SUCCEED);
//	}
//	
//}
