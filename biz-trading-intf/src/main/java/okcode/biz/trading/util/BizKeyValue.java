/**
 * @Project: biz-trading-intf
 * @File: BizKey.java
 * @Package okcode.biz.trading.util
 * @Description:
 * @author micwing
 * @date 2013-7-25 下午3:57:31
 * @version V1.0
 *
 * Copyright (c) 2013 BGoal Soft Studio. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package okcode.biz.trading.util;

import okcode.framework.type.LabeledEnum;

/** 
 * @ClassName: BizKey 
 * @Description: 
 * @author micwing
 * @date 2013-7-25 下午3:57:31 
 */
public enum BizKeyValue implements LabeledEnum {
//	BIZKEY_IDENTITY(""),
//	BIZKEY_IDENTITY_MODIFY_PASSWORD(""),
	
	COUNT_SERVICE_ARTICLE_CLICKS("文章点击次数"),
	
	CONFIG_SERVICE_SYS_CONFIG_BASE_CONFIG("系统设置-基本设置"),
	CONFIG_SERVICE_SYS_CONFIG_EMAIL_CONFIG("系统设置-邮箱配置"),
	CONFIG_SERVICE_SYS_CONFIG_RUN_STATUS("系统设置-运行状态"),
	CONFIG_SERVICE_SYS_CONFIG_IMAGE_CONFIG("系统设置-图片配置"),
	CONFIG_SERVICE_SYS_CONFIG_SAFETY_CONFIG("系统设置-安全配置"),
	
	CONFIG_SERVICE_FACE_STYLE_BOTTOM_INFO("界面风格-底部信息"),
	CONFIG_SERVICE_FACE_STYLE_FRONT_HOME_CONFIG("界面风格-前台首页设置"),
	CONFIG_SERVICE_COLUMN_CONFIG("栏目规划"),
	CONFIG_SERVICE_CONTENT_MANAGER("内容管理"),
	CONFIG_SERVICE_USER_MANAGER("用户管理");
	
	String label;
	
	BizKeyValue(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
