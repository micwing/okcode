package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class RunStatusDto implements CommonConfigDto {
	
	public RunStatusDto setMap(Map<String, String> map) {
		this.runStatus = map.get("runStatus");
		this.recoverTime = map.get("recoverTime");
		this.siteNotice = map.get("siteNotice");
		return this;
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("runStatus", getRunStatus());
		map.put("recoverTime", getRecoverTime());
		map.put("siteNotice", getSiteNotice());
		return map;
	}
	
	public Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add("runStatus");
		set.add("recoverTime");
		set.add("siteNotice");
		return set;
	}
	
	private Long userId;
	
	private String runStatus;
	
	private String recoverTime;
	
	private String siteNotice;
	
	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public String getRecoverTime() {
		return recoverTime;
	}

	public void setRecoverTime(String recoverTime) {
		this.recoverTime = recoverTime;
	}

	public String getSiteNotice() {
		return siteNotice;
	}

	public void setSiteNotice(String siteNotice) {
		this.siteNotice = siteNotice;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
