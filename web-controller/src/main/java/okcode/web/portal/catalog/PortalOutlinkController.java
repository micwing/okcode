package okcode.web.portal.catalog;

import okcode.biz.trading.enums.Module;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.model.Catalog;
import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 平台门户请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/portal/outlink")
public class PortalOutlinkController extends BaseController {
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value="/{alias}",method = RequestMethod.GET)
	public String index(@PathVariable("alias") String alias) {
		Catalog catalog = catalogService.findByAlias(Module.outlink, alias);
		if (catalog == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "未找到该栏目");
		return "redirect:"+catalog.getAttributes().get(Catalog.ATTR_KEY_OUTLINK_URL);
	}
	
}
