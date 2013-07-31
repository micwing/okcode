package okcode.web.portal.home;
//package okcode.web.portal;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.result.Result;
//import okcode.framework.web.VerifyCodeServlet;
//import okcode.service.standard.intf.UserAuthService;
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
//@RequestMapping(value = "/signfind")
//public class SignfindController extends BaseController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private UserAuthService userAuthService;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String index() {
//		return PORTAL+"signfind/index";
//	}
//	
//	@RequestMapping(value = "/doFind", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doFind(HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestParam("username") String credential,
//			@RequestParam("email") String email) {
//		//验证码
//		boolean paptchaFlag = VerifyCodeServlet.validate(request);
//		if (!paptchaFlag)
//			return new Result(ErrorCode.PAPTCHA_NOT_MATCH);
//		
//		User temp = userService.findUser(credential);
//		if (temp == null || !temp.getEmail().equals(email))
//			throw new AppException(ErrorCode.ENTITY_ALREADY_EXIST, "用户名与邮箱不匹配");
//		
//		userService.sendResetPasswordEmail(temp.getId(), email);
//		
//		return new Result("重置密码的邮件已经发送，请前往邮箱查看！");
//	}
//	
//	@RequestMapping(value = "/modifyPassword/{passwordUrl}", method = RequestMethod.GET)
//	public ModelAndView modifyPassword(@PathVariable("passwordUrl") String passwordUrl) {
//		if (StringUtils.isEmpty(passwordUrl))
//			throw new AppException(ErrorCode.MISS_PARAM);
//		User user = userService.findUserByPasswordUrl(passwordUrl);
//		ModelAndView mav = new ModelAndView(PORTAL+"signfind/modifyPassword");
//		mav.addObject("user", user);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/doModifyPassword", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doModifyPassword(
//			@RequestParam("userId") Long userId,
//			@RequestParam("password") String password, 
//			@RequestParam("passwordUrl") String passwordUrl) {
//		if (userId == null || StringUtils.isEmpty(passwordUrl)||StringUtils.isEmpty(passwordUrl))
//			throw new AppException(ErrorCode.MISS_PARAM);
//		User user = userService.findUserByPasswordUrl(passwordUrl);
//		if (user == null)
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND);
//		if (user.getId().longValue() != userId.longValue())
//			throw new AppException(ErrorCode.NO_PERMISSON);
//		userAuthService.updatePassword(userId, password);
//		userService.clearUpdatePasswordUrlStr(userId);
//		return new Result("密码重置成功，去登录吧！");
//	}
//}
