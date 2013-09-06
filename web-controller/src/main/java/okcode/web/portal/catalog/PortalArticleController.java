package okcode.web.portal.catalog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okcode.biz.trading.dto.CommonConfigDto;
import okcode.biz.trading.dto.ImageConfigDto;
import okcode.biz.trading.enums.Module;
import okcode.biz.trading.intf.ArticleService;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.intf.CommonConfigService;
import okcode.biz.trading.model.Article;
import okcode.biz.trading.model.Catalog;
import okcode.biz.trading.util.BizKeyValue;
import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.web.base.BaseController;

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
	@Autowired
	private CommonConfigService commonConfigService;
	
	@RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
	public ModelAndView catalogList(@PathVariable("cid") Long cid, Pageable page) {
		Catalog catalog = catalogService.findById(cid);
		if (catalog == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "栏目未找到！");
		List<Catalog> allCatalogs = new ArrayList<Catalog>();
		allCatalogs.add(catalog);
		allCatalogs.addAll(catalogService.findAllByParent(catalog.getId()));
		
		Set<Long> ids = new HashSet<Long>();
		for (Catalog c : allCatalogs)
			ids.add(c.getId());
		//TODO size 10
		Page<Article> articlePage = articleService.list(catalog.getModule(), ids,
				null, page);
		
		ModelAndView mav = new ModelAndView(PORTAL+"article/list");
		mav.addObject("articleList", articlePage.getContent());
		mav.addObject("page", articlePage);
		mav.addObject("catalog", catalog);
		mav.setViewName(PORTAL+"article/"+catalog.getModule()+"-list");
		return mav;
	}
	
	@RequestMapping(value = "/detail/{aid}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("aid") Long aid) {
		Article article = articleService.findById(aid);
		if (article == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "内容未找到！");
		Catalog catalog = article.getCatalog();
		
		ModelAndView mav = new ModelAndView();
		Module module = article.getCatalog().getModule();
		mav.setViewName(PORTAL+"article/"+module+"-detail");
		mav.addObject("article", article);
		mav.addObject("catalog", catalog);
		if (catalog.getModule().ordinal() == Module.product.ordinal()
				|| catalog.getModule().ordinal() == Module.image.ordinal()
				|| catalog.getModule().ordinal() == Module.download.ordinal()) {
			mav.addObject("imageConfig", commonConfigService.find(
					new ImageConfigDto(), BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_IMAGE_CONFIG));
		}
		return mav;
	}
}
