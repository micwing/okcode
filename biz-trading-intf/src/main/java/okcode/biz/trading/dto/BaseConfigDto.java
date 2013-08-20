package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class BaseConfigDto implements CommonConfigDto {
	
	public BaseConfigDto setMap(Map<String, String> map) {
		this.systemName = map.get("systemName");
		this.siteLogoUrl = map.get("siteLogoUrl");
		this.siteUrl = map.get("siteUrl");
		this.siteKeyword = map.get("siteKeyword");
		this.siteDescription = map.get("siteDescription");
		return this;
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("systemName", getSystemName());
		map.put("siteLogoUrl", getSiteLogoUrl());
		map.put("siteUrl", getSiteUrl());
		map.put("siteKeyword", getSiteKeyword());
		map.put("siteDescription", getSiteDescription());
		return map;
	}
	
	public Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add("systemName");
		set.add("siteLogoUrl");
		set.add("siteUrl");
		set.add("siteKeyword");
		set.add("siteDescription");
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
