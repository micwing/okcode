package okcode.framework.springmvc.resolver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.framework.result.Result;

public class AppExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		response.setCharacterEncoding("UTF-8");
		
		if (handler instanceof HandlerMethod) {
			
			HandlerMethod hm = (HandlerMethod) handler;
			
			if (hm.getMethod().isAnnotationPresent(ResponseBody.class)) {
				if (ex instanceof AppException) {
					AppException aex = (AppException)ex;
					try {
						PrintWriter writer = response.getWriter();
						Result result = new Result(aex);
						writer.write(JSON.toJSONString(result));
						writer.flush();
					} catch (IOException e) {
						//ignore
					}
					return null;
				} else {
					try {
						PrintWriter writer = response.getWriter();
						Result result = new Result(ErrorCode.SERVER_ERROR);
						writer.write(JSON.toJSONString(result));
						writer.flush();
					} catch (IOException e) {
						//ignore
					}
					return null;
				}
				
			} else {
				
				if (ex instanceof AppException) {
					ModelAndView mav = new ModelAndView("common/error");
					return mav;
				} else {
					ModelAndView mav = new ModelAndView("console/404");
					return mav;
				}
			}
		} else {
			return null;
		}
	}

}
