package okcode.web.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okcode.biz.trading.dto.BaseConfigDto;
import okcode.biz.trading.dto.BottomInfoDto;
import okcode.biz.trading.dto.CatalogItem;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.intf.CommonConfigService;
import okcode.biz.trading.model.Catalog;
import okcode.biz.trading.util.BizKeyValue;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PortalInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private CommonConfigService commonConfigService;
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		if (mav == null)
			return;
		
		if ((mav.getViewName() != null)  && (!mav.getViewName().startsWith("redirect")))
			mav.addObject("requestServletPath", request.getServletPath()+"/");
		
		List<CatalogItem> navCatalogItems = catalogService.listNavCatalogItems();
		mav.addObject("navCatalogItems", navCatalogItems);
		mav.addObject("bottomCatalogs", catalogService.listBottomCatalogs());
		mav.addObject("baseConfig", commonConfigService.find(
				new BaseConfigDto(), BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_BASE_CONFIG));
		mav.addObject("bottomInfo", commonConfigService.find(
				new BottomInfoDto(), BizKeyValue.CONFIG_SERVICE_FACE_STYLE_BOTTOM_INFO));
		
		Object catalogObj = mav.getModel().get("catalog");
		if (catalogObj != null) {
			Catalog catalog = (Catalog) catalogObj;
			Catalog navCatalog = catalogService.findNavCatalog(catalog);
			mav.addObject("navCatalog", navCatalog);
			mav.addObject("breadCatalogs", catalogService.findNavBreadCatalogs(catalog));
			addSideCatalogItems(navCatalog, mav, navCatalogItems);
		}
	}
	
	private void addSideCatalogItems(Catalog catalog,
						ModelAndView mav, List<CatalogItem> catalogItems) {
		List<CatalogItem> sideCatalogs = null;
		if (!CollectionUtils.isEmpty(catalogItems)) {
			for (CatalogItem ci : catalogItems) {
				if (ci.getCatalog().getId() == catalog.getId()) {						
					sideCatalogs = ci.getSubCatalog();
				} else {
					if (!CollectionUtils.isEmpty(ci.getSubCatalog())) {						
						for (CatalogItem cii : ci.getSubCatalog()) {
							if (cii.getCatalog().getId() == catalog.getId())
								sideCatalogs = cii.getSubCatalog();
						}
					}
				}
			}
			
		}
		mav.addObject("sideCatalogItems", sideCatalogs);
	}
}
