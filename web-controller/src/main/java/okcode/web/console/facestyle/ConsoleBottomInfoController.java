package okcode.web.console.facestyle;

import okcode.biz.trading.dto.BottomInfoDto;
import okcode.biz.trading.intf.CommonConfigService;
import okcode.biz.trading.util.BizKeyValue;
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
@RequestMapping(value = "/console/bottomInfo")
public class ConsoleBottomInfoController extends BaseController {
	@Autowired
	private CommonConfigService commonConfigService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "bottomInfo/index");
		mav.addObject("dto", commonConfigService.find(
				new BottomInfoDto(), BizKeyValue.CONFIG_SERVICE_FACE_STYLE_BOTTOM_INFO));
		return mav;
	}
	
	@RequestMapping(value = "/doSaveBottomInfo", method = RequestMethod.POST)
	@ResponseBody
	public Result doSaveBottomInfo(BottomInfoDto dto) {
		commonConfigService.save(dto, BizKeyValue.CONFIG_SERVICE_FACE_STYLE_BOTTOM_INFO);
		Result result = new Result("保存成功！");
		return result;
	}
	
}
