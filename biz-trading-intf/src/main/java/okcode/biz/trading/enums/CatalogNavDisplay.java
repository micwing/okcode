package okcode.biz.trading.enums;

import okcode.framework.type.LabeledEnum;

/**
 * 分类等级类型枚举
 */
public enum CatalogNavDisplay implements LabeledEnum {
	NONE("不显示"),
	MAIN("主导航栏"),
	BOTTOM("底部导航栏"),
	BOTH("都显示");
	
	public static final CatalogNavDisplay[] ALL_MAIN = {MAIN, BOTH};
	
	public static final CatalogNavDisplay[] ALL_BOTTOM = {BOTTOM, BOTH};
	
	String label;
	
	CatalogNavDisplay(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
	
}
