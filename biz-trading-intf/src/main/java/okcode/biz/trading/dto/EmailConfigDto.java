package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class EmailConfigDto implements CommonConfigDto {
	
	public EmailConfigDto setMap(Map<String, String> map) {
		this.senderName = map.get("senderName");
		this.address = map.get("address");
		this.stmpServer = map.get("stmpServer");
		this.password = map.get("password");
		return this;
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("senderName", getSenderName());
		map.put("address", getAddress());
		map.put("stmpServer", getStmpServer());
		map.put("password", getPassword());
		return map;
	}
	
	public Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add("senderName");
		set.add("address");
		set.add("stmpServer");
		set.add("password");
		return set;
	}
	
	private Long userId;
	
	private String senderName;
	
	private String address;
	
	private String stmpServer;
	
	private String password;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStmpServer() {
		return stmpServer;
	}

	public void setStmpServer(String stmpServer) {
		this.stmpServer = stmpServer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
