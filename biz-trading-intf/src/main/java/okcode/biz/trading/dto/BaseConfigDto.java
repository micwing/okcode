package okcode.biz.trading.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class BaseConfigDto {
	
	public BaseConfigDto() {
	}
	
	public BaseConfigDto(Map<String, String> map) {
		//TODO
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}
	
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public static Set<String> getKeys() {
		Set<String> set = new HashSet<String>();
//		set.add(e);
		return set;
	}
	
}
