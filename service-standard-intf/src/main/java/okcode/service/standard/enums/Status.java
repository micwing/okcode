package okcode.service.standard.enums;

import okcode.framework.type.LabeledEnum;


public enum Status implements LabeledEnum {
	NORMAL("正常"),
	PAUSED("已停用"),
	DELETED("已删除");
	
	String label;
	
	Status(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
