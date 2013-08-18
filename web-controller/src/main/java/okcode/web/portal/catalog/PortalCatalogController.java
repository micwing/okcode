package okcode.web.portal.catalog;

import java.util.Collections;
import java.util.List;

import okcode.biz.trading.enums.CatalogClickDisplay;
import okcode.biz.trading.enums.Module;
import okcode.biz.trading.intf.ArticleService;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.model.Article;
import okcode.biz.trading.model.Catalog;
import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.web.base.BaseController;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * 平台栏目访问请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value="/portal/catalog")
public class PortalCatalogController extends BaseController {
	
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/{module}/{alias}",method = RequestMethod.GET)
	public ModelAndView index(@PathVariable("module") Module module,
			@PathVariable("alias") String alias, Pageable page) {
		//点击的栏目
		Catalog catalog = catalogService.findByAlias(module, alias);
		if (catalog == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "栏目未找到！");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("navCatalog", catalogService.findNavCatalog(catalog));
		mav.addObject("breadCatalogs", catalogService.findNavBreadCatalogs(catalog));
		if (catalog.getClickDisplay().ordinal() == CatalogClickDisplay.FIRST_CONTENT.ordinal()) {
			//显示本栏目第一个内容
			
			List<Article> articles = articleService.findByCatalogId(Collections.singleton(catalog.getId()));
			if (CollectionUtils.isEmpty(articles))
				throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "内容未找到！");
			mav.setViewName("forward:/portal/article/detail/"+articles.get(0).getId());
			
		} else if (catalog.getClickDisplay().ordinal() == CatalogClickDisplay.FIRST_SUB_PAGE.ordinal()) {
			//显示第一个子栏目点击后的显示
			
			List<Catalog> catalogs = catalogService.findByParent(catalog.getId());
			if (CollectionUtils.isEmpty(catalogs))
				throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "子栏目未找到！");
			mav.setViewName("forward:/portal/catalog/"+catalogs.get(0).getModule().toString()+"/"+catalogs.get(0).getAlias());
			
		} else if (catalog.getClickDisplay().ordinal() == CatalogClickDisplay.CONTENT_LIST.ordinal()) {
			//显示栏目内容列表
			
			mav.setViewName("forward:/portal/article/list/"+catalog.getId());
			
		}
		return mav;
	}
	
}
