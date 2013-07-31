package okcode.web.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ConsoleInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		if (mav == null)
			return;
		
		if ((mav.getViewName() != null)  && (!mav.getViewName().startsWith("redirect")))
			mav.addObject("requestServletPath", request.getServletPath()+"/");
		
	}
}
