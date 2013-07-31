package okcode.biz.trading.enums;

import okcode.framework.type.LabeledEnum;

/**
 */
public enum CatalogClickDisplay implements LabeledEnum {
	FIRST_CONTENT("本栏目第一个内容 "),
	FIRST_SUB_PAGE("显示第一个子栏目点击后的显示"),
	CONTENT_LIST("栏目内容列表"),
	SUB_CONTENT_LIST("子栏目内容列表");
	
	String label;
	
	CatalogClickDisplay(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
	
}
