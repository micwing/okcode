package okcode.service.standard.message.service.impl;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import okcode.framework.exception.ErrorCode;
import okcode.framework.result.Result;
import okcode.service.standard.intf.EmailService;

/**
 * 站内信服务
 */
@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSenderImpl noreplyMailSender;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Override
	public Result sendHtmlEmail(String to,String title,String templateName, Map<String, String> rootMap) {
		MimeMessage mailMessage = noreplyMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,  
                "UTF-8");
		try {
			messageHelper.setFrom(noreplyMailSender.getUsername());
			messageHelper.setTo(to);
			messageHelper.setSubject(title);
			String content = FreeMarkerTemplateUtils.processTemplateIntoString(
					freeMarkerConfigurer.getConfiguration().getTemplate(templateName), rootMap);
			messageHelper.setText(content, true);
		} catch (Exception e1) {
			return new Result(ErrorCode.SERVER_ERROR,e1.getMessage());
		}
		noreplyMailSender.send(mailMessage);
		return new Result();
	}


}
