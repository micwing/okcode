package okcode.web.console.sysconfig;

import okcode.biz.trading.dto.BaseConfigDto;
import okcode.biz.trading.dto.EmailConfigDto;
import okcode.biz.trading.dto.RunStatusDto;
import okcode.biz.trading.intf.CommonConfigService;
import okcode.biz.trading.util.BizKeyValue;
import okcode.framework.result.Result;
import okcode.framework.result.ResultType;
import okcode.service.standard.intf.EmailService;
import okcode.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 门户商品请求controller
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/console/baseConfig")
public class ConsoleBaseConfigController extends BaseController {
	@Autowired
	private JavaMailSenderImpl noreplyMailSender;
	@Autowired
	private CommonConfigService commonConfigService;
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(CONSOLE + "baseConfig/index");
		mav.addObject("dto", commonConfigService.find(
				new BaseConfigDto(), BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_BASE_CONFIG));
		return mav;
	}
	
	@RequestMapping(value = "/doSaveBaseConfig", method = RequestMethod.POST)
	@ResponseBody
	public Result doSaveBaseConfig(BaseConfigDto dto) {
		commonConfigService.save(dto, BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_BASE_CONFIG);
		Result result = new Result("保存成功！");
		return result;
	}
	
	@RequestMapping(value = "/emailConfig", method = RequestMethod.GET)
	public ModelAndView emailConfig() {
		ModelAndView mav = new ModelAndView(CONSOLE + "baseConfig/emailConfig");
		mav.addObject("dto", commonConfigService.find(
				new EmailConfigDto(), BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_EMAIL_CONFIG));
		return mav;
	}
	
	@RequestMapping(value = "/doSaveEmailConfig", method = RequestMethod.POST)
	@ResponseBody
	public Result doSaveEmailConfig(EmailConfigDto dto) {
		commonConfigService.save(dto, BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_EMAIL_CONFIG);
		noreplyMailSender.setHost(dto.getStmpServer());
		noreplyMailSender.setPassword(dto.getPassword());
		noreplyMailSender.setPort(Integer.parseInt(dto.getPort()));
		noreplyMailSender.setUsername(dto.getAddress());
		Result result = new Result("保存成功！");
		return result;
	}
	
	@RequestMapping(value = "/doSendTestEmail", method = RequestMethod.POST)
	@ResponseBody
	public Result doSendTestEmail(EmailConfigDto dto) {
		doSaveEmailConfig(dto);
		try {
			emailService.sendTextEmail(dto.getTestEmailAddress(), "测试邮件", "如果您收到这封邮件，说明邮箱配置正确！");
		} catch (Exception e) {
			Result result = new Result("测试邮件已发送失败，请检查邮件配置！");
			result.setResultType(ResultType.error);
			return result;
		}
		Result result = new Result("测试邮件已发送，请到接收邮箱查看！");
		return result;
	}
	
	@RequestMapping(value = "/runStatus", method = RequestMethod.GET)
	public ModelAndView runStatus() {
		ModelAndView mav = new ModelAndView(CONSOLE + "baseConfig/runStatus");
		mav.addObject("dto", commonConfigService.find(
				new RunStatusDto(), BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_RUN_STATUS));
		return mav;
	}
	
	@RequestMapping(value = "/doSaveRunStatus", method = RequestMethod.POST)
	@ResponseBody
	public Result doSaveRunStatus(RunStatusDto dto) {
		commonConfigService.save(dto, BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_RUN_STATUS);
		Result result = new Result("保存成功！");
		return result;
	}
	
}
