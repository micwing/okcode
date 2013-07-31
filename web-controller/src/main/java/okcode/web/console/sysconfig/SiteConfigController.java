package okcode.web.console.sysconfig;
//package okcode.web.console;
//
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
//import okcode.service.standard.enums.Status;
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
//@RequestMapping(value = "/console/siteConfig")
//public class SiteConfigController extends BaseController {
//	@Autowired
//	private SiteService siteService;
//	@Autowired
//	private TemplateService templateService;
//	
//	@RequestMapping(value = "/baseInfo", method = RequestMethod.GET)
//	public ModelAndView baseInfo(@RequestParam("siteId") Long siteId) {
//		Site site = siteService.findById(siteId);
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteConfig/baseInfo");
//		mav.addObject("site", site);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/chooseTemplate", method = RequestMethod.GET)
//	public ModelAndView chooseTemplate(@RequestParam("siteId") Long siteId) {
//		User user = getCurrentUser();
//		Site site = siteService.findById(siteId);
//		Module module = site.getTemplate().getModule();
//		List<Template> tempaltes = templateService.getUserTemplates(module,user.getId());
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteConfig/chooseTemplate");
//		mav.addObject("site", site);
//		mav.addObject("tempaltes", tempaltes);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/runStatus", method = RequestMethod.GET)
//	public ModelAndView runStatus(@RequestParam("siteId") Long siteId) {
//		Site site = siteService.findById(siteId);
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteConfig/runStatus");
//		mav.addObject("site", site);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/seoOptimize", method = RequestMethod.GET)
//	public ModelAndView seoOptimize(@RequestParam("siteId") Long siteId) {
//		Site site = siteService.findById(siteId);
//		ModelAndView mav = new ModelAndView(CONSOLE + "siteConfig/seoOptimize");
//		mav.addObject("site", site);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/doSaveTemplate", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doSaveTemplate(
//			@RequestParam("siteId") Long siteId,
//			@RequestParam("templateId") Long templateId) {
//		if (siteId == null)
//			return new Result(ErrorCode.MISS_PARAM);
//		User user = getCurrentUser();
//		Site site = siteService.findById(siteId);
//		Template template = templateService.findById(templateId);
//		site.setTemplate(template);
//		siteService.updateTemplate(site, user.getId());
//		Result result = new Result(ErrorCode.SUCCEED, site.getName()+"模板保存成功");
//		result.setValue(site.getId()+"");
//		return result;
//	}
//	
//	@RequestMapping(value = "/doUpdateSeoInfo", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doUpdateSeoInfo(
//			@RequestParam("siteId") Long siteId,
//			@RequestParam("seoTitle") String seoTitle,
//			@RequestParam("seoKeywords") String seoKeywords,
//			@RequestParam("seoDescription") String seoDescription) {
//		if (siteId == null)
//			return new Result(ErrorCode.MISS_PARAM);
//		User user = getCurrentUser();
//		Site site = siteService.findById(siteId);
//		site.setSeoTitle(seoTitle);
//		site.setSeoKeywords(seoKeywords);
//		site.setSeoDescription(seoDescription);
//		site = siteService.updateSeoInfo(site, user.getId());
//		Result result = new Result(ErrorCode.SUCCEED, site.getName()+"SEO信息保存成功");
//		result.setValue(site.getId()+"");
//		return result;
//	}
//	
//	@RequestMapping(value = "/doUpdateBaseInfo", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doUpdateBaseInfo(Site site) {
//		if (site == null)
//			return new Result(ErrorCode.MISS_PARAM);
//		User user = getCurrentUser();
//		site = siteService.updateBaseInfo(site,user.getId());
//		Result result = new Result(ErrorCode.SUCCEED, site.getName()+"基本配置保存成功");
//		result.setValue(site.getId()+"");
//		return result;
//	}
//	
//	@RequestMapping(value = "/doChangeStatus", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doChangeStatus(@RequestParam("siteId") Long siteId, Status status) {
//		if (siteId == null || status == null)
//			return new Result(ErrorCode.MISS_PARAM);
//		User user = getCurrentUser();
//		Site site = null;
//		site = siteService.changeStatus(siteId, status, user.getId());
//		Result result = new Result(ErrorCode.SUCCEED, site.getName()+"状态已改变");
//		result.setValue(siteId+"");
//		return result;
//	}
//	
//	@RequestMapping(value = "/doSavePausedNotice", method = RequestMethod.POST)
//	@ResponseBody
//	public Result doSavePausedNotice(@RequestParam("siteId") Long siteId, String notice) {
//		if (siteId == null)
//			return new Result(ErrorCode.MISS_PARAM);
//		User user = getCurrentUser();
//		siteService.savePausedNotice(siteId, notice, user.getId());
//		Result result = new Result(ErrorCode.SUCCEED,"公告保存成功");
//		result.setValue(siteId+"");
//		return result;
//	}
//}
