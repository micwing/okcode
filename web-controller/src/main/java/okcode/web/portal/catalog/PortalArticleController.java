package okcode.web.portal.catalog;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 * 平台文章访问请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/portal/article")
public class PortalArticleController extends BaseController {
	
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
	public ModelAndView catalogList(@PathVariable("cid") Long cid, Pageable page) {
		Catalog catalog = catalogService.findById(cid);
		if (catalog == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "栏目未找到！");
		
		//TODO size 10
		Page<Article> articlePage = articleService.list(catalog.getModule(), Collections.singleton(catalog.getId()),
				null, page);
		
		ModelAndView mav = new ModelAndView(PORTAL+"article/list");
		mav.addObject("articleList", articlePage.getContent());
		mav.addObject("page", articlePage);
		mav.addObject("catalog", catalog);
		mav.setViewName(PORTAL+"article/list");
		return mav;
	}
	
	@RequestMapping(value = "/sublist/{cid}", method = RequestMethod.GET)
	public ModelAndView catalogSubList(@PathVariable("cid") Long cid, Pageable page) {
		Catalog catalog = catalogService.findById(cid);
		if (catalog == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "栏目未找到！");
		
		List<Catalog> catalogs = catalogService.findByParent(catalog.getId());
		Page<Article> articlePage = null;
		if (!CollectionUtils.isEmpty(catalogs)) {
			Set<Long> cids = new HashSet<Long>();
			for (Catalog ca : catalogs)
				cids.add(ca.getId());
			//TODO size 10
			articlePage = articleService.list(catalog.getModule(), cids, null, page);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("articleList", articlePage == null ? null : articlePage.getContent());
		mav.addObject("page", articlePage);
		mav.setViewName(PORTAL+"article/list");
		
		return mav;
	}
	
	@RequestMapping(value = "/detail/{aid}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("aid") Long aid) {
		Article article = articleService.findById(aid);
		if (article == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "内容未找到！");
		ModelAndView mav = new ModelAndView();
		Module module = article.getCatalog().getModule();
		if (module.ordinal() == Module.article.ordinal())
			mav.setViewName(PORTAL+"article/"+module+"-detail");
		mav.addObject("article", article);
		return mav;
	}
}
