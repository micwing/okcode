package okcode.web.portal.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import okcode.web.base.BaseController;


/**
 * 平台门户请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/portal/home")
public class PortalHomeController extends BaseController {
	/**
	 * 门户首页
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(PORTAL+"home/index");
		return mav;
	}
	
	/**
	 * coming soon
	 * @return
	 */
	@RequestMapping(value = "/coming", method = RequestMethod.GET)
	public ModelAndView coming() {
		ModelAndView mav = new ModelAndView("portal/home/coming");
		return mav;
	}
	
}
