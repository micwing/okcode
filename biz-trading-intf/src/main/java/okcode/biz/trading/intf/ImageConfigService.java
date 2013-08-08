package okcode.biz.trading.intf;

import okcode.biz.trading.dto.ImageConfigDto;

import org.springframework.validation.annotation.Validated;

@Validated
public interface ImageConfigService {
	
	void saveImageConfig(ImageConfigDto dto);
	
	ImageConfigDto findImageConfig();
	
}
