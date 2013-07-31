/**
 * @Project: main-framework
 * @File: MessageProperty.java
 * @package okcode.framework.property
 * @Description:
 * @author micwing
 * @date 2013-3-26 下午4:52:45
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
package okcode.framework.property;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okcode.framework.utils.SpringContextUtil;

/** 
 * @ClassName: MessageProperty 
 * @Description: 
 * @author micwing
 * @date 2013-3-26 下午5:29:19 
 */ 
public abstract class MessageProperty {

	private static final Logger logger = LoggerFactory
			.getLogger(MessageProperty.class);

	public static final String PREFIX = "errorcode.";
	private static Properties props = new Properties();

	static {
		try {
			InputStream is = SpringContextUtil.getApplicationContext()
					.getResource("classpath:/message.properties")
					.getInputStream();

			props.load(is);
		} catch (FileNotFoundException e) {
			logger.warn("FileNotFoundException occure" + e);
		} catch (IOException e) {
			logger.warn("IOException occure" + e);
		}

	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}
	
	public static String getValue(int code) {
		return props.getProperty(PREFIX+code);
	}
}
