package okcode.biz.trading.enums;

import okcode.framework.type.LabeledEnum;

/**
 * 业务模块枚举
 */
public enum Module implements LabeledEnum {
	article("文章模块"),
	
	product("产品模块"),
	image("图片模块"),
	download("下载模块"),
	message("留言模块"),
	
	job("招聘模块"),
	exlink("友链模块"),
	
	sitemap("网站地图模块"),
	search("搜索模块"),
	outlink("外链模块");
	
	String label;
	
	Module(String label){
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
