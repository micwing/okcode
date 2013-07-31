package okcode.service.standard.intf;

import java.util.Map;

import okcode.framework.result.Result;


/**
 * 邮件发送服务接口
 */
public interface EmailService {

	Result sendHtmlEmail(String to,String title,String templateName, Map<String, String> rootMap);
}