package okcode.service.standard.enums;

import okcode.framework.type.LabeledEnum;

/**
 * 区域等级类型枚举
 */
public enum AreaLevel implements LabeledEnum {
	OTHER("其他"),
	COUNTRY("国家"),
	PROVINCE("省"),
	CITY("市"),
	COUNTY("区县");
	
	String label;
	
	AreaLevel(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
