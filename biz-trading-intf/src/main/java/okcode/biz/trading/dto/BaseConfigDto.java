package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import okcode.biz.trading.util.ConfigConstants;


public class BaseConfigDto {
	
	public BaseConfigDto() {
	}
	
	public BaseConfigDto(Map<String, String> map) {
		this.systemName = map.get(ConfigConstants.BASECONFIG_SYSTEM_NAME);
		this.siteLogoUrl = map.get(ConfigConstants.BASECONFIG_SITE_LOGO_URL);
		this.siteUrl = map.get(ConfigConstants.BASECONFIG_SITE_URL);
		this.siteKeyword = map.get(ConfigConstants.BASECONFIG_SITE_KEYWORD);
		this.siteDescription = map.get(ConfigConstants.BASECONFIG_SITE_DESCRIPTION);
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(ConfigConstants.BASECONFIG_SYSTEM_NAME, getSystemName());
		map.put(ConfigConstants.BASECONFIG_SITE_LOGO_URL, getSiteLogoUrl());
		map.put(ConfigConstants.BASECONFIG_SITE_URL, getSiteUrl());
		map.put(ConfigConstants.BASECONFIG_SITE_KEYWORD, getSiteKeyword());
		map.put(ConfigConstants.BASECONFIG_SITE_DESCRIPTION, getSiteDescription());
		return map;
	}
	
	public static Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add(ConfigConstants.BASECONFIG_SYSTEM_NAME);
		set.add(ConfigConstants.BASECONFIG_SITE_LOGO_URL);
		set.add(ConfigConstants.BASECONFIG_SITE_URL);
		set.add(ConfigConstants.BASECONFIG_SITE_KEYWORD);
		set.add(ConfigConstants.BASECONFIG_SITE_DESCRIPTION);
		return set;
	}
	
	private Long userId;
	
	private String systemName;
	
	private String siteLogoUrl;
	
	private String siteUrl;
	
	private String siteKeyword;
	
	private String siteDescription;
	
	
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSiteLogoUrl() {
		return siteLogoUrl;
	}

	public void setSiteLogoUrl(String siteLogoUrl) {
		this.siteLogoUrl = siteLogoUrl;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getSiteKeyword() {
		return siteKeyword;
	}

	public void setSiteKeyword(String siteKeyword) {
		this.siteKeyword = siteKeyword;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
