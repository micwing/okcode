package okcode.web.portal.home;

import okcode.biz.trading.dto.FrontHomeConfigDto;
import okcode.biz.trading.intf.ArticleService;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.intf.CommonConfigService;
import okcode.biz.trading.intf.FrontHomeConfigService;
import okcode.biz.trading.util.BizKeyValue;
import okcode.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * 平台门户请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/portal/home")
public class PortalHomeController extends BaseController {
	
	@Autowired
	private CommonConfigService commonConfigService;
	@Autowired
	private FrontHomeConfigService frontHomeConfigService;
	/**
	 * 门户首页
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(PORTAL+"home/index");
		FrontHomeConfigDto dto = (FrontHomeConfigDto) commonConfigService.find(
				new FrontHomeConfigDto(), BizKeyValue.CONFIG_SERVICE_FACE_STYLE_FRONT_HOME_CONFIG);
		dto = frontHomeConfigService.getFrontHomeInfos(dto);
		mav.addObject("dto", dto);
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
