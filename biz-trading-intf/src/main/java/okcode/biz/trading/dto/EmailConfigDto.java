package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class EmailConfigDto implements CommonConfigDto {
	
	public EmailConfigDto setMap(Map<String, String> map) {
		this.port = map.get("port");
		this.address = map.get("address");
		this.stmpServer = map.get("stmpServer");
		this.password = map.get("password");
		this.testEmailAddress = map.get("testEmailAddress");
		return this;
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("port", getPort());
		map.put("address", getAddress());
		map.put("stmpServer", getStmpServer());
		map.put("password", getPassword());
		map.put("testEmailAddress", getTestEmailAddress());
		return map;
	}
	
	public Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
		set.add("port");
		set.add("address");
		set.add("stmpServer");
		set.add("password");
		set.add("testEmailAddress");
		return set;
	}
	
	private Long userId;
	
	private String port;
	
	private String address;
	
	private String stmpServer;
	
	private String password;
	
	private String testEmailAddress;
	
	public String getTestEmailAddress() {
		return testEmailAddress;
	}

	public void setTestEmailAddress(String testEmailAddress) {
		this.testEmailAddress = testEmailAddress;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
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
