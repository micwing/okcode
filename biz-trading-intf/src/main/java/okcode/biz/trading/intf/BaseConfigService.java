package okcode.biz.trading.intf;

import okcode.biz.trading.dto.BaseConfigDto;
import okcode.biz.trading.dto.EmailConfigDto;
import okcode.biz.trading.dto.RunStatusDto;

import org.springframework.validation.annotation.Validated;

@Validated
public interface BaseConfigService {
	
	void saveBaseConfig(BaseConfigDto dto);
	
	BaseConfigDto findBaseConfig();
	
	
	void saveEmailConfig(EmailConfigDto dto);
	
	EmailConfigDto findEmailConfig();
	
	
	void saveRunStatus(RunStatusDto dto);
	
	RunStatusDto findRunStatus();
}
