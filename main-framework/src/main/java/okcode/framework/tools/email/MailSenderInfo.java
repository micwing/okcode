/**
 * @Project: main-framework
 * @File: MailSenderInfo.java
 * @package okcode.framework.tools.email
 * @Description:
 * @author micwing
 * @date 2013-6-25 下午3:59:18
 * @version V1.0
 *
 * Copyright (c) 2013 OneKr Soft Studio. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package okcode.framework.tools.email;

import java.util.Properties;

/**
 * @ClassName: MailSenderInfo
 * @Description:
 * @author micwing
 * @date 2013-6-25 下午3:59:18
 */
public class MailSenderInfo {
	// 发送邮件的服务器的IP和端口
	protected String mailServerHost;
	protected String mailServerPort = "25";
	// 邮件发送者的地址
	protected String fromAddress;
	// 邮件接收者的地址
	protected String toAddress;
	// 登陆邮件发送服务器的用户名和密码
	protected String userName;
	protected String password;
	// 是否需要身份验证
	protected boolean validate = false;
	// 邮件主题
	protected String subject;
	// 邮件的文本内容
	protected String content;
	// 邮件附件的文件名
	protected String[] attachFileNames;

	/**
	 * 获得邮件会话属性
	 */
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] fileNames) {
		this.attachFileNames = fileNames;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String textContent) {
		this.content = textContent;
	}
}
