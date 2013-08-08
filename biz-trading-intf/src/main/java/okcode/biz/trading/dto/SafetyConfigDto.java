package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class SafetyConfigDto {
	
	public SafetyConfigDto() {
	}
	
	public SafetyConfigDto(Map<String, String> map) {
		this.adminLoginVerificationCode = map.get("adminLoginVerificationCode");
		this.portalSubmitVerificationCode = map.get("portalSubmitVerificationCode");
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("adminLoginVerificationCode", getAdminLoginVerificationCode());
		map.put("portalSubmitVerificationCode", getPortalSubmitVerificationCode());
		return map;
	}
	
	public static Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add("adminLoginVerificationCode");
		set.add("portalSubmitVerificationCode");
		return set;
	}
	
	private Long userId;
	
	private String adminLoginVerificationCode;
	
	private String portalSubmitVerificationCode;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAdminLoginVerificationCode() {
		return adminLoginVerificationCode;
	}

	public void setAdminLoginVerificationCode(String adminLoginVerificationCode) {
		this.adminLoginVerificationCode = adminLoginVerificationCode;
	}

	public String getPortalSubmitVerificationCode() {
		return portalSubmitVerificationCode;
	}

	public void setPortalSubmitVerificationCode(String portalSubmitVerificationCode) {
		this.portalSubmitVerificationCode = portalSubmitVerificationCode;
	}
	
}
