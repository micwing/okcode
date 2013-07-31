package okcode.web.console.sysconfig;
//package okcode.web.console;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.result.Result;
//import okcode.mall.api.service.trading.SiteService;
//import okcode.mall.core.model.Site;
//import okcode.mall.core.model.User;
//import okcode.mall.web.base.BaseController;
//
//
///**
// * 门户商品请求controller
// * 
// * @author Administrator
// * 
// */
//@Controller
//@RequestMapping(value = "/console/siteSystemHandle")
//public class SiteSystemHandleController extends BaseController {
//	@Autowired
//	private SiteService siteService;
//	
//	@RequestMapping(value = "/visitCount", method = RequestMethod.GET)
//	public ModelAndView visitCount(@RequestParam("siteId") Long siteId) {
//		Site site = siteService.findById(siteId);
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteConfig/baseInfo");
//		mav.addObject("site", site);
//		return layoutMav(this, mav);
//	}
//	
//	@RequestMapping(value = "/leaveMessage", method = RequestMethod.GET)
//	public ModelAndView leaveMessage(@RequestParam("siteId") Long siteId) {
//		Site site = siteService.findById(siteId);
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteConfig/baseInfo");
//		mav.addObject("site", site);
//		return layoutMav(this, mav);
//	}
//	
//	@RequestMapping(value = "/fileManage", method = RequestMethod.GET)
//	public ModelAndView fileManage(@RequestParam("siteId") Long siteId) {
//		Site site = siteService.findById(siteId);
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteConfig/baseInfo");
//		mav.addObject("site", site);
//		return layoutMav(this, mav);
//	}
//	
//	@RequestMapping(value = "/operateLog", method = RequestMethod.GET)
//	public ModelAndView operateLog(@RequestParam("siteId") Long siteId) {
//		Site site = siteService.findById(siteId);
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteConfig/baseInfo");
//		mav.addObject("site", site);
//		return layoutMav(this, mav);
//	}
//	
//}
