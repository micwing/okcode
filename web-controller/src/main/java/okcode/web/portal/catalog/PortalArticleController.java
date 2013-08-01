package okcode.web.portal.catalog;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/article")
public class PortalArticleController extends BaseController {
	
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
		if (catalog.getClickDisplay().ordinal() == CatalogClickDisplay.FIRST_CONTENT.ordinal()) {
			//显示本栏目第一个内容
			
			List<Article> articles = articleService.findByCatalogId(Collections.singleton(catalog.getId()));
			if (CollectionUtils.isEmpty(articles))
				throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "内容未找到！");
			mav.addObject("article", articles.get(0));
			mav.setViewName(PORTAL+"article/detail");
			
		} else if (catalog.getClickDisplay().ordinal() == CatalogClickDisplay.FIRST_SUB_PAGE.ordinal()) {
			//显示第一个子栏目点击后的显示
			
			List<Catalog> catalogs = catalogService.findByParent(catalog.getId());
			if (CollectionUtils.isEmpty(catalogs))
				throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "子栏目未找到！");
			mav.setViewName("redirect:/portal/"+catalogs.get(0).getModule().toString()+"/"+catalogs.get(0).getAlias());
			
		} else if (catalog.getClickDisplay().ordinal() == CatalogClickDisplay.CONTENT_LIST.ordinal()) {
			//显示栏目内容列表
			
			//TODO size 10
			Page<Article> articlePage = articleService.list(catalog.getModule(), Collections.singleton(catalog.getId()),
					null, page);
			mav.addObject("articleList", articlePage.getContent());
			mav.addObject("page", articlePage);
			mav.addObject("catalog", catalog);
			mav.setViewName(PORTAL+"article/list");
			
		} else if (catalog.getClickDisplay().ordinal() == CatalogClickDisplay.SUB_CONTENT_LIST.ordinal()) {
			//显示子栏目内容列表
			
			List<Catalog> catalogs = catalogService.findByParent(catalog.getId());
			Page<Article> articlePage = null;
			if (!CollectionUtils.isEmpty(catalogs)) {
				Set<Long> cids = new HashSet<Long>();
				for (Catalog ca : catalogs)
					cids.add(ca.getId());
				//TODO size 10
				articlePage = articleService.list(catalog.getModule(), cids, null, page);
			}
			mav.addObject("articleList", articlePage == null ? null : articlePage.getContent());
			mav.addObject("page", articlePage);
			mav.setViewName(PORTAL+"article/list");
			
		}
		return mav;
	}
	
	@RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("cid") Long cid) {
		ModelAndView mav = new ModelAndView(PORTAL+"news/list");
		return mav;
	}
	
	@RequestMapping(value = "/sublist/{cid}", method = RequestMethod.GET)
	public ModelAndView sublist(@PathVariable("cid") Long cid) {
		ModelAndView mav = new ModelAndView(PORTAL+"news/list");
		return mav;
	}
	
	@RequestMapping(value = "/detail/{aid}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("aid") Long aid) {
		Article article = articleService.findById(aid);
		if (article == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "内容未找到！");
		ModelAndView mav = new ModelAndView(PORTAL+"news/detail");
		mav.addObject("article", article);
		return mav;
	}
}
