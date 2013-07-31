package okcode.web.console.sysconfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import okcode.web.base.BaseController;


/**
 * 门户商品请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/console/dataBackup")
public class ConsoleDataBackupController extends BaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "dataBackup/index");
		return mav;
	}
	
	@RequestMapping(value = "/dbDataList",method = RequestMethod.GET)
	public ModelAndView dbDataList() {
		ModelAndView mav = new ModelAndView(CONSOLE + "dataBackup/dbDataList");
		return mav;
	}
	
	@RequestMapping(value = "/fileDataList", method = RequestMethod.GET)
	public ModelAndView fileDataList() {
		ModelAndView mav = new ModelAndView(CONSOLE + "dataBackup/fileDataList");
		return mav;
	}
	
}
