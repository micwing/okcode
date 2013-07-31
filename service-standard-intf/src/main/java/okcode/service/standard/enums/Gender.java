/**
 * @Project: main-core
 * @File: Gender.java
 * @package okcode.mall.core.enums
 * @Description:
 * @author micwing
 * @date 2013-4-2 下午5:13:19
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
package okcode.service.standard.enums;

import okcode.framework.type.LabeledEnum;

/** 
 * @ClassName: Gender 
 * @Description: 
 * @author micwing
 * @date 2013-4-2 下午5:13:19 
 */
public enum Gender implements LabeledEnum {
	UNKONW("未知"),
	MALE("男"),
	FEMALE("女");
	
	String label;
	
	Gender(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
