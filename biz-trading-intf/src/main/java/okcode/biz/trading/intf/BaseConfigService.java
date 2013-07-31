package okcode.biz.trading.intf;

import okcode.biz.trading.dto.BaseConfigDto;

import org.springframework.validation.annotation.Validated;

@Validated
public interface BaseConfigService {
	
	void saveBaseConfig(BaseConfigDto dto);
	
	BaseConfigDto findBaseConfig();
}
