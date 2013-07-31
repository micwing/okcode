package okcode.web.console.colconfig;

import okcode.biz.trading.enums.CatalogNavDisplay;
import okcode.biz.trading.enums.Module;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.model.Catalog;
import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.framework.result.Result;
import okcode.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 门户商品请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/console/columnConfig")
public class ConsoleColumnConfigController extends BaseController {
	
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "columnConfig/index");
		mav.addObject("catalogItems", catalogService.listCatalogItems());
		return mav;
	}
	
	@RequestMapping(value = "/add",  method = RequestMethod.GET)
	public ModelAndView add(Module module, Long pid) {
		ModelAndView mav = new ModelAndView(CONSOLE + "columnConfig/normal-detail");
		Catalog catalog = new Catalog();
		catalog.setModule(module);
		catalog.setPid(pid);
		if (pid != null && pid > 0)
			catalog.setNavDisplay(CatalogNavDisplay.NONE);
		mav.addObject("catalog", catalog);
		mav.addObject("catalogItems", catalogService.listCatalogItems());
		return mav;
	}
	
	@RequestMapping(value = "/modify",  method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam("cid") Long cid) {
		Catalog catalog = catalogService.findById(cid);
		if (catalog == null) 
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "没找到该栏目，请刷新后再试！");
		ModelAndView mav = new ModelAndView(CONSOLE + "columnConfig/normal-detail");
		mav.addObject("catalog", catalog);
		mav.addObject("catalogItems", catalogService.listCatalogItems());
		mav.addObject("subCatalogs", catalogService.findByParent(catalog.getId()));
		return mav;
	}
	
	@RequestMapping(value = "/doSave", method = RequestMethod.POST)
	@ResponseBody
	public Result doSave(Catalog catalog) {
		catalog.setRank(catalog.getRank() != null ? catalog.getRank() : 0);
		Result result = new Result();
		catalog = catalogService.saveCatalog(catalog);
		if (catalog.getId() == null) {			
			result.setMessage("栏目添加成功！");
		} else {
			result.setMessage("栏目更新成功！");
		}
		result.setValue(catalog);
		return result;
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Result doDelete(@RequestParam("cid") Long cid) {
		try {
			catalogService.deleteCatalog(cid);
		} catch (AppException e) {
			return new Result(e);
		}
		return new Result("删除成功！");
	}
}
