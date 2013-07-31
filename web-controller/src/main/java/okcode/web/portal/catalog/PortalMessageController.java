package okcode.web.portal.catalog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/portal/message")
public class PortalMessageController extends BaseController {
	
	@RequestMapping(value="/{alias}",method = RequestMethod.GET)
	public ModelAndView index(@PathVariable("alias") String alias) {
		ModelAndView mav = new ModelAndView(PORTAL+"news/index");
		return mav;
	}
	
	@RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("cid") Long cid) {
		ModelAndView mav = new ModelAndView(PORTAL+"news/list");
		return mav;
	}
	
	@RequestMapping(value = "/detail/{aid}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("aid") Long aid) {
		ModelAndView mav = new ModelAndView(PORTAL+"news/detail");
		return mav;
	}
}
