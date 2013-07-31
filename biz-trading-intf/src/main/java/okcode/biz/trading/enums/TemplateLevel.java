package okcode.biz.trading.enums;

import okcode.framework.type.LabeledEnum;

/**
 * 区域等级类型枚举
 */
public enum TemplateLevel implements LabeledEnum {
	OTHER("其他"),
	NORMAL("普通模板"),
	ADVANCED("高级模板");
	
	String label;
	
	TemplateLevel(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
