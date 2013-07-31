package okcode.web.console.better;

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
@RequestMapping(value = "/console/cacheConfig")
public class ConsoleCacheConfigController extends BaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "cacheConfig/index");
		return mav;
	}
	
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public ModelAndView config() {
		ModelAndView mav = new ModelAndView(CONSOLE + "cacheConfig/config");
		return mav;
	}
	
}
