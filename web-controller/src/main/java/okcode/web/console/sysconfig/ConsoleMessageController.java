package okcode.web.console.sysconfig;

import okcode.framework.result.Result;
import okcode.service.standard.intf.MessageService;
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
@RequestMapping(value = "/console/message")
public class ConsoleMessageController extends BaseController {
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "redirect:/console/message/inbox";
	}
	
	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	public ModelAndView inbox() {
		ModelAndView mav = new ModelAndView(CONSOLE + "message/inbox");
		return mav;
	}
	
	@RequestMapping(value = "/outbox", method = RequestMethod.GET)
	public ModelAndView outbox() {
		ModelAndView mav = new ModelAndView(CONSOLE + "message/outbox");
		return mav;
	}
	
	@RequestMapping(value = "/draftsbox", method = RequestMethod.GET)
	public ModelAndView drafts() {
		ModelAndView mav = new ModelAndView(CONSOLE + "message/draftsbox");
		return mav;
	}
	
	@RequestMapping(value = "/newone", method = RequestMethod.GET)
	public ModelAndView newone() {
		ModelAndView mav = new ModelAndView(CONSOLE + "message/newone");
		return mav;
	}
	
	@RequestMapping(value = "/countInbox", method = RequestMethod.GET)
	@ResponseBody
	public Result countInbox() {
//		User user = getCurrentUser();
//		Result result = new Result();
//		int count = messageService.countMesage(null, user.getId(), Status.NORMAL, false);
//		result.setMessage(count+"");
//		return result;
		return null;
	}
	
}
