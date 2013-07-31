package okcode.web.console.sysconfig;
//package okcode.web.console;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.result.Result;
//import okcode.service.standard.intf.UserAuthService;
//import okcode.service.standard.intf.UserService;
//import okcode.service.standard.model.User;
//import okcode.service.standard.model.UserAuth;
//import okcode.web.base.BaseController;
//
//
///**
// * @author Administrator
// * 
// */
//@Controller
//@RequestMapping(value = "/console/user")
//public class UserController extends BaseController {
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private UserAuthService userAuthService;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView user() throws AppException{
//		ModelAndView mav = new ModelAndView(CONSOLE + "user/index");
//		mav.addObject("user", userService.findUser(getCurrentUser().getId()));
//		return mav;
//	}
//	
//	@RequestMapping(value = "uploadPhoto", method = RequestMethod.GET)
//	public ModelAndView uploadPhoto() throws AppException{
//		ModelAndView mav = new ModelAndView(CONSOLE + "user/uploadPhoto");
//		mav.addObject("user", getCurrentUser());
//		return mav;
//	}
//	
//	@RequestMapping(value = "bindEmail", method = RequestMethod.GET)
//	public ModelAndView bindEmail() throws AppException{
//		ModelAndView mav = new ModelAndView(CONSOLE + "user/bindEmail");
//		mav.addObject("user", getCurrentUser());
//		return mav;
//	}
//	
//	@RequestMapping(value = "modifyPassword", method = RequestMethod.GET)
//	public ModelAndView modifyPassword() throws AppException{
//		ModelAndView mav = new ModelAndView(CONSOLE + "user/modifyPassword");
//		mav.addObject("user", getCurrentUser());
//		return mav;
//	}
//	
//	@RequestMapping(value = "doSaveBaseInfo", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doSaveBaseInfo(User user) {
//		User current = getCurrentUser();
//		if (user == null)
//			throw new AppException(ErrorCode.MISS_PARAM, "缺少必要的参数");
//		user.setId(current.getId());
//		userService.updateBaseInfo(user);
//		
//		//update shrio user cache
//		UserAuth userAuth = userAuthService.findUserAuth(current.getId());
//		UsernamePasswordToken token = new UsernamePasswordToken(userAuth.getUser().getUserName(), userAuth.getPassword());
//		Subject currentUser = SecurityUtils.getSubject();  
//		currentUser.logout();
//		currentUser.login(token);
//		
//		return new Result(ErrorCode.SUCCEED, "保存基本信息成功");
//	}
//	
//}
