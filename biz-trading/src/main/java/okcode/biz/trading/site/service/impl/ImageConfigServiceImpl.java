package okcode.biz.trading.site.service.impl;

import java.util.Map;

import okcode.biz.trading.dto.ImageConfigDto;
import okcode.biz.trading.intf.ImageConfigService;
import okcode.biz.trading.util.BizKeyValue;
import okcode.service.standard.intf.ConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ImageConfigServiceImpl implements ImageConfigService {

	@Autowired
	private ConfigService configService;
	
	@Override
	public void saveImageConfig(ImageConfigDto dto) {
		Map<String, String> ownerValues = dto.toMap();
		configService.saveConfigs(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_IMAGE_CONFIG.toString(), ownerValues, 0L);
	}

	@Override
	public ImageConfigDto findImageConfig() {
		Map<String, String> map = configService.findConfigValues(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_IMAGE_CONFIG.toString(), ImageConfigDto.getKeys());
		return new ImageConfigDto(map);
	}

}
