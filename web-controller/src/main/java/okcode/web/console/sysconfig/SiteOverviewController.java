package okcode.web.console.sysconfig;
//package okcode.web.console;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import okcode.biz.trading.intf.SiteService;
//import okcode.biz.trading.model.Site;
//import okcode.web.base.BaseController;
//
//
///**
// * 门户商品请求controller
// * 
// * @author Administrator
// * 
// */
//@Controller
//@RequestMapping(value = "/console/siteOverview")
//public class SiteOverviewController extends BaseController {
//	@Autowired
//	private SiteService siteService;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView index(@RequestParam("siteId") Long siteId) {
//		Site site = siteService.findById(siteId);
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteOverview/index");
//		mav.addObject("site", site);
//		return mav;
//	}
//	
//}
