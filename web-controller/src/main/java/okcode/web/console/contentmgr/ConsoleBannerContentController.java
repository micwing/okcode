package okcode.web.console.contentmgr;

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
@RequestMapping(value = "/console/bannerContent")
public class ConsoleBannerContentController extends BaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "bannerContent/index");
		return mav;
	}
	
	@RequestMapping(value= "/bannerList", method = RequestMethod.GET)
	public ModelAndView bannerList() {
		ModelAndView mav = new ModelAndView(CONSOLE + "bannerContent/bannerList");
		return mav;
	}
	
}
