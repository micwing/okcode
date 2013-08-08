package okcode.web.console.sysconfig;

import okcode.biz.trading.dto.SafetyConfigDto;
import okcode.biz.trading.intf.SafetyConfigService;
import okcode.framework.result.Result;
import okcode.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 门户商品请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/console/safetyConfig")
public class ConsoleSafetyConfigController extends BaseController {
	
	@Autowired
	private SafetyConfigService safetyConfigService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "safetyConfig/index");
		mav.addObject("dto", safetyConfigService.findSafetyConfig());
		return mav;
	}
	
	@RequestMapping(value = "/doSaveSafetyConfig", method = RequestMethod.POST)
	@ResponseBody
	public Result doSaveSafetyConfig(SafetyConfigDto dto) {
		safetyConfigService.saveSafetyConfig(dto);
		Result result = new Result("保存成功！");
		return result;
	}
	
}
