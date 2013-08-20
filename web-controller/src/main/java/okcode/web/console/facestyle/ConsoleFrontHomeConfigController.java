package okcode.web.console.facestyle;

import java.util.List;

import okcode.biz.trading.dto.BottomInfoDto;
import okcode.biz.trading.dto.FrontHomeConfigDto;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.intf.CommonConfigService;
import okcode.biz.trading.model.Catalog;
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
@RequestMapping(value = "/console/frontHomeConfig")
public class ConsoleFrontHomeConfigController extends BaseController {
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private CommonConfigService commonConfigService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "frontHomeConfig/index");
		List<Catalog> allCatalogs = catalogService.findAll();
		mav.addObject("allCatalogs", allCatalogs);
		mav.addObject("dto", commonConfigService.find(
				new FrontHomeConfigDto(), BizKeyValue.CONFIG_SERVICE_FACE_STYLE_FRONT_HOME_CONFIG));
		return mav;
	}
	
	@RequestMapping(value = "/doSaveFrontHomeConfig", method = RequestMethod.POST)
	@ResponseBody
	public Result doSaveBottomInfo(FrontHomeConfigDto dto) {
		commonConfigService.save(dto, BizKeyValue.CONFIG_SERVICE_FACE_STYLE_FRONT_HOME_CONFIG);
		Result result = new Result("保存成功！");
		return result;
	}
	
}
