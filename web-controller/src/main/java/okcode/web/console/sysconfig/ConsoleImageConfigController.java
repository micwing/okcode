package okcode.web.console.sysconfig;

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
@RequestMapping(value = "/console/imageConfig")
public class ConsoleImageConfigController extends BaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "imageConfig/index");
		return mav;
	}

	@RequestMapping(value = "watermarkConfig",method = RequestMethod.GET)
	public ModelAndView watermarkConfig() {
		ModelAndView mav = new ModelAndView(CONSOLE + "imageConfig/watermarkConfig");
		return mav;
	}
	
}
