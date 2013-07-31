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
@RequestMapping(value = "/console/sideContent")
public class ConsoleSideContentController extends BaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "redirect:/console/sideContent/feedbackModule";
	}
	
	@RequestMapping(value = "/feedbackModule", method = RequestMethod.GET)
	public ModelAndView feedbackModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "sideContent/feedbackModule");
		return mav;
	}
	
	@RequestMapping(value = "/articleModule", method = RequestMethod.GET)
	public ModelAndView articleModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "sideContent/articleModule");
		return mav;
	}

	@RequestMapping(value = "/productModule", method = RequestMethod.GET)
	public ModelAndView productModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "sideContent/productModule");
		return mav;
	}
	
	@RequestMapping(value = "/downloadModule", method = RequestMethod.GET)
	public ModelAndView downloadModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "sideContent/downloadModule");
		return mav;
	}
	
	@RequestMapping(value = "/imageModule", method = RequestMethod.GET)
	public ModelAndView imageModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "sideContent/imageModule");
		return mav;
	}
	
	@RequestMapping(value = "/jobModule", method = RequestMethod.GET)
	public ModelAndView jobModule() {
		ModelAndView mav = new ModelAndView(CONSOLE + "sideContent/jobModule");
		return mav;
	}
	
}
