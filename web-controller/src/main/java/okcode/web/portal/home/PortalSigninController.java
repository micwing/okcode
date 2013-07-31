package okcode.web.portal.home;
//package okcode.web.portal;
//
//import java.util.Enumeration;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.crypto.hash.Md5Hash;
//import org.apache.shiro.subject.Subject;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.result.Result;
//import okcode.framework.web.VerifyCodeServlet;
//import okcode.service.standard.enums.UserGroup;
//import okcode.service.standard.model.UserAuth;
//import okcode.web.base.BaseController;
//
//
///**
// * 登录Controller
// * 
// * @author MICHAEL
// */
//@Controller
//@RequestMapping(value = "/signin")
//public class SigninController extends BaseController {
//	
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public String index() {
//		if (getCurrentUser() != null)
//			return redirect();
//		return PORTAL+"signin/index";
//	}
//
//	@RequestMapping(value = "/doSignin", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doSignin(HttpServletRequest request,
//			HttpServletResponse response,
//			@RequestParam("username") String credential,
//			@RequestParam("password") String password,
//			@RequestParam(value="remember",required=false) String remember) {
//		//验证码
//		boolean paptchaFlag = VerifyCodeServlet.validate(request);
//		if (!paptchaFlag)
//			return new Result(ErrorCode.PAPTCHA_NOT_MATCH);
//		
//		UsernamePasswordToken token = new UsernamePasswordToken(credential, new Md5Hash(password).toHex());
//		if (!StringUtils.isEmpty(remember)) {
//			token.setRememberMe(true);
//		}
//		
//		Subject currentUser = SecurityUtils.getSubject();  
//		try {
//			currentUser.login(token);
//		} catch (AuthenticationException e) {
//			throw new AppException(ErrorCode.USER_PSW_NOT_MATCH);
//			//return new Result(ErrorCode.USER_PSW_NOT_MATCH);
//		}
//		
//		return new Result(ErrorCode.SUCCEED);
//	}
//	
//	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
//	public String redirect() {
//		UserAuth ua = getCurrentUserAuth();
//		UserGroup userGroup = ua.getUserGroup();
//		if (UserGroup.USER.equals(userGroup)) {
//			return "redirect:/console";
//		}
//		return "redirect:/signin";
//	}
//
//	@RequestMapping(value = "/doSignout", method = RequestMethod.GET)
//	public String doSignout() {
//		Subject currentUser = SecurityUtils.getSubject();
//		currentUser.logout();
//		
//		//清除session
//		HttpSession session = getSession();
//        Enumeration<?> em = session.getAttributeNames();
//        while(em.hasMoreElements()){
//        	session.removeAttribute(em.nextElement().toString());
//        }
//        session.invalidate();
//        
//		return "redirect:/signin";
//	}
//	
//}
