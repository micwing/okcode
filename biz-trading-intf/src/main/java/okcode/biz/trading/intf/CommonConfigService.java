package okcode.biz.trading.intf;

import okcode.biz.trading.dto.CommonConfigDto;
import okcode.biz.trading.util.BizKeyValue;

import org.springframework.validation.annotation.Validated;

@Validated
public interface CommonConfigService {
	
	void save(CommonConfigDto dto, BizKeyValue bizKeyValue);
	
	CommonConfigDto find(CommonConfigDto dto, BizKeyValue bizKeyValue);
	
}
