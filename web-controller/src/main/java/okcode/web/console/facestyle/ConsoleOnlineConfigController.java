package okcode.web.console.facestyle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import okcode.web.base.BaseController;


/**
 * 门户商品请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/console/onlineConfig")
public class ConsoleOnlineConfigController extends BaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "onlineConfig/index");
		return mav;
	}
	
	@RequestMapping(value = "/styleConfig", method = RequestMethod.GET)
	public ModelAndView styleConfig() {
		ModelAndView mav = new ModelAndView(CONSOLE + "onlineConfig/styleConfig");
		return mav;
	}
	
}
