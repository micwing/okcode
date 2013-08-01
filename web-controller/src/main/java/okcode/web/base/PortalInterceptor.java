package okcode.web.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okcode.biz.trading.intf.BaseConfigService;
import okcode.biz.trading.intf.CatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PortalInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private BaseConfigService baseConfigService;
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		if (mav == null)
			return;
		
		if ((mav.getViewName() != null)  && (!mav.getViewName().startsWith("redirect")))
			mav.addObject("requestServletPath", request.getServletPath()+"/");
		
		mav.addObject("catalogItems", catalogService.listNavCatalogItems());
		mav.addObject("baseConfig", baseConfigService.findBaseConfig());
	}
}
