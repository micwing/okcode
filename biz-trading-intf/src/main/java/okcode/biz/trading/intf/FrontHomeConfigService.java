package okcode.biz.trading.intf;

import okcode.biz.trading.dto.FrontHomeConfigDto;

import org.springframework.validation.annotation.Validated;

@Validated
public interface FrontHomeConfigService {

	FrontHomeConfigDto getFrontHomeInfos(FrontHomeConfigDto dto);
}
