//package okcode.web.facade;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.shiro.util.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import okcode.biz.trading.intf.SiteService;
//import okcode.biz.trading.model.Site;
//import okcode.biz.trading.util.BizConstants;
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.service.standard.enums.Status;
//import okcode.service.standard.intf.ArticleService;
//import okcode.service.standard.intf.CatalogService;
//import okcode.service.standard.intf.CountService;
//import okcode.service.standard.intf.FileStoreService;
//import okcode.service.standard.model.Article;
//import okcode.service.standard.model.Catalog;
//import okcode.service.standard.model.FileStore;
//import okcode.service.standard.util.ArticleConverter;
//import okcode.service.standard.util.CatalogConverter;
//import okcode.service.standard.util.CatalogItem;
//import okcode.web.base.BaseController;
//
//
///**
// * 店面请求controller
// * 
// * @author Administrator
// * 
// */
//@Controller
//@RequestMapping(value = "/site")
//public class FacadeSiteController extends BaseController {
//	@Autowired
//	private SiteService siteService;
//	@Autowired
//	private CatalogService catalogService;
//	@Autowired
//	private ArticleService articleService;
//	@Autowired
//	private FileStoreService fileStoreService;
//	@Autowired
//	private CountService countService;
//	
//	@RequestMapping(value = "/{alias}", method = RequestMethod.GET)
//	public ModelAndView index(@PathVariable("alias") String alias) throws AppException {
//		Site site = siteService.findByAlias(alias);
//		if (site == null)
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "小站未找到");
//		
//		ModelAndView mav = new ModelAndView(
//				TPL + site.getTemplate().getModule().name().toLowerCase() + "/" + site.getTemplate().getAlias() + "/index");
//		mav.addObject("site", site);
//		
//		if (site.getStatus() == Status.PAUSED) {
//			mav.setViewName(PORTAL+"home/paused");
//			return mav;
//		}
//		
//		List<Catalog> catalogs = catalogService.findByBizOwner(BizConstants.HANDBILLS_MENU_CATALOG, site.getId(), Collections.singleton(Status.NORMAL));
//		List<CatalogItem> items = CatalogConverter.toCatalogItem(catalogs);
//		mav.addObject("catalogItems", items);
//		
//		Map<Long, List<Article>> articleMap = new HashMap<Long, List<Article>>();
//		if (!CollectionUtils.isEmpty(catalogs)) {
//			List<Article> articles = articleService.findByBizOwners(BizConstants.HANDBILLS_MENU_DISH, CatalogConverter.toIds(catalogs), Collections.singleton(Status.NORMAL));
//			articleMap = ArticleConverter.toOwnerMap(articles);
//		}
//		mav.addObject("articleMap", articleMap);
//		
//		List<FileStore> boardFileStores = fileStoreService.findByBizOwner(BizConstants.HANDBILLS_AD_BOARD_FILE, Collections.singleton(site.getId()));
//		mav.addObject("boardFileStores", boardFileStores);
//		
//		countService.addCountByBizOwner(BizConstants.COUNT_SITE, site.getId());
//		
//		return mav;
//	}
//
//}
