package okcode.web.console.sysconfig;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import okcode.biz.trading.dto.SafetyConfigDto;
import okcode.biz.trading.intf.CommonConfigService;
import okcode.biz.trading.util.BizKeyValue;
import okcode.framework.exception.ErrorCode;
import okcode.framework.result.Result;
import okcode.framework.web.VerifyCodeServlet;
import okcode.service.standard.enums.UserGroup;
import okcode.service.standard.model.UserAuth;
import okcode.web.base.BaseController;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录Controller
 * 
 * @author MICHAEL
 */
@Controller
@RequestMapping(value = "/console/signin")
public class ConsoleSigninController extends BaseController {
	@Autowired
	private CommonConfigService conmmonConfigService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		SafetyConfigDto safetyConfigDto = (SafetyConfigDto) conmmonConfigService.find(
				new SafetyConfigDto(), BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_SAFETY_CONFIG);
		ModelAndView mav = new ModelAndView("console/signin/index");
		mav.addObject("safetyConfigDto", safetyConfigDto);
		return mav;
	}

	@RequestMapping(value = "/doSignin", method = RequestMethod.POST)
	@ResponseBody
	public Result doSignin(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("username") String credential,
			@RequestParam("password") String password,
			@RequestParam(value="remember",required=false) String remember) {
		SafetyConfigDto safetyConfigDto = (SafetyConfigDto) conmmonConfigService.find(
				new SafetyConfigDto(), BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_SAFETY_CONFIG);
		if (safetyConfigDto.getAdminLoginVerificationCode() != null
				&& Boolean.parseBoolean(safetyConfigDto.getAdminLoginVerificationCode())) {
			//验证码
			boolean paptchaFlag = VerifyCodeServlet.validate(request);
			if (!paptchaFlag)
				return new Result(ErrorCode.PAPTCHA_NOT_MATCH);
		}
		
		UsernamePasswordToken token = new UsernamePasswordToken(credential, new Md5Hash(password).toHex());
		if (!StringUtils.isEmpty(remember)) {
			token.setRememberMe(true);
		}
		
		Subject currentUser = SecurityUtils.getSubject();  
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			//throw new AppException(ErrorCode.USER_PSW_NOT_MATCH);
			return new Result(ErrorCode.USER_PSW_NOT_MATCH);
		}
		
		//ckfinder
		request.getSession().setAttribute("CKFinder_UserRole", getCurrentUserAuth().getUserGroup().toString());
		
		return new Result(ErrorCode.SUCCEED);
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirect() {
		UserAuth ua = getCurrentUserAuth();
		UserGroup userGroup = ua.getUserGroup();
		if (UserGroup.ADMIN.equals(userGroup)) {
			return "redirect:/console/home";
		}
		return "redirect:/console/signin";
	}

	@RequestMapping(value = "/doSignout", method = RequestMethod.GET)
	public String doSignout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		//清除session
		HttpSession session = getSession();
        Enumeration<?> em = session.getAttributeNames();
        while(em.hasMoreElements()){
        	session.removeAttribute(em.nextElement().toString());
        }
        session.invalidate();
        
		return "redirect:/console/signin";
	}
	
	
	@RequestMapping(value = "/signfind", method = RequestMethod.GET)
	public String signfind() {
		return "console/signin/signfind";
	}
}
