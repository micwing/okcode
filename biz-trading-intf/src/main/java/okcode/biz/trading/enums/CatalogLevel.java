package okcode.biz.trading.enums;

import okcode.framework.type.LabeledEnum;

/**
 * 分类等级类型枚举
 */
public enum CatalogLevel implements LabeledEnum {
	FIRST("一级分类"),
	SECOND("二级分类"),
	THIRD("三级分类");
	
	String label;
	
	CatalogLevel(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
