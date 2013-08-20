package okcode.biz.trading.dto;

import java.util.Map;
import java.util.Set;



public interface CommonConfigDto {
	
	Map<String, String> toMap();
	
	CommonConfigDto setMap(Map<String, String> map);
	
	Set<String> getKeys();
}
