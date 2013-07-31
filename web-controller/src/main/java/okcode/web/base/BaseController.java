/**
 * @Project: web-controller
 * @File: BaseController.java
 * @package okcode.web.base
 * @Description:
 * @author micwing
 * @date 2013-3-26 下午5:41:09
 * @version V1.0
 *
 * Copyright (c) 2013 OneKr Soft Studio. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package okcode.web.base;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import okcode.framework.springmvc.editor.NormalDateEditor;
import okcode.service.standard.model.UserAuth;

/** 
 * @ClassName: BaseController 
 * @Description: 
 * @author micwing
 * @date 2013-3-26 下午5:41:09 
 */
public abstract class BaseController {
	public static final String CONSOLE = "console:";
	public static final String PORTAL = "portal:";
	
//	@Autowired
//	private SiteService siteService;
	
	protected HttpSession getSession() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
		HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();  
		HttpSession session = request.getSession();
		return session;
	}
	
//	protected ModelAndView layoutMav(BaseController controller, ModelAndView mav) {
//		mav.addObject("_controllerName", controller.getClass().getSimpleName());
//		User user = getCurrentUser();
//		if (user != null) {
//			List<Site> sites = siteService.findByUser(user.getId());
//			mav.addObject("_sites", sites);
//		}
//		return mav;
//	}
	
	protected UserAuth getCurrentUserAuth() {
		PrincipalCollection pc = SecurityUtils.getSubject().getPrincipals();
		return pc == null ? null : (UserAuth) pc.getPrimaryPrincipal();
	}
	
//	protected User getCurrentUser() {
//		UserAuth ua = getCurrentUserAuth();
//		return ua == null ? null : ua.getUser();
//	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new NormalDateEditor());
	}
}
