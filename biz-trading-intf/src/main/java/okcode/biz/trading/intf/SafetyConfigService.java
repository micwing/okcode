package okcode.biz.trading.intf;

import okcode.biz.trading.dto.SafetyConfigDto;

import org.springframework.validation.annotation.Validated;

@Validated
public interface SafetyConfigService {
	
	void saveSafetyConfig(SafetyConfigDto dto);
	
	SafetyConfigDto findSafetyConfig();
	
}
