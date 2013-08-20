package okcode.web.console.sysconfig;

import okcode.biz.trading.dto.ImageConfigDto;
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
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/console/imageConfig")
public class ConsoleImageConfigController extends BaseController {
	
	@Autowired
	private CommonConfigService commonConfigService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "imageConfig/index");
		mav.addObject("dto", commonConfigService.find(
				new ImageConfigDto(), BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_IMAGE_CONFIG));
		return mav;
	}
	
	@RequestMapping(value = "/doSaveImageConfig", method = RequestMethod.POST)
	@ResponseBody
	public Result doSaveImageConfig(ImageConfigDto dto) {
		commonConfigService.save(dto, BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_IMAGE_CONFIG);
		Result result = new Result("保存成功！");
		return result;
	}
	
}
