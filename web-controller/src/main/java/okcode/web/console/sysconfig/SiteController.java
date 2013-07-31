package okcode.web.console.sysconfig;
//package okcode.web.console;
//
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import okcode.biz.trading.enums.Module;
//import okcode.biz.trading.intf.SiteService;
//import okcode.biz.trading.intf.TemplateService;
//import okcode.biz.trading.model.Site;
//import okcode.biz.trading.model.Template;
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.result.Result;
//import okcode.service.standard.model.User;
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
//@RequestMapping(value = "/console/site")
//public class SiteController extends BaseController {
//	@Autowired
//	private SiteService siteService;
//	@Autowired
//	private TemplateService templateService;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView index() {
//		ModelAndView mav = new ModelAndView(CONSOLE + "site/list");
//		mav.addObject("sites", siteService.findByUser(getCurrentUser().getId()));
//		return mav;
//	}
//	
//	@RequestMapping(value = "/create", method = RequestMethod.GET)
//	public ModelAndView create() {
//		ModelAndView mav = new ModelAndView(CONSOLE + "site/create");
//		//mav.addObject("templates", templateService.findAll());
//		return mav;
//	}
//	
//	@RequestMapping(value = "/getUserTemplates", method = RequestMethod.POST)
//	@ResponseBody
//	public Result getUserTemplates(Module module) {
//		User user = getCurrentUser();
//		List<Template> templates = null;
//		templates = templateService.getUserTemplates(module, user.getId());
//		Result result = new Result();
//		result.setValue(templates);
//		return result;
//	}
//	
//	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doCreate(Site site) {
//		if (site == null)
//			return new Result(ErrorCode.MISS_PARAM);
//		User user = getCurrentUser();
//		site.setUser(user);
//		site = siteService.create(site);
//		Result result = new Result(ErrorCode.SUCCEED, site.getName()+"创建成功");
//		result.setValue(site.getId()+"");
//		return result;
//	}
//	
//	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doDelete(@RequestParam("siteId") Long siteId) {
//		if (siteId == null)
//			return new Result(ErrorCode.MISS_PARAM);
//		User user = getCurrentUser();
//		siteService.deleteByUser(Collections.singleton(siteId), user.getId());
//		Result result = new Result(ErrorCode.SUCCEED, "删除成功");
//		return result;
//	}
//	
//}
