package okcode.biz.trading.site.service.impl;

import java.util.Map;

import okcode.biz.trading.dto.SafetyConfigDto;
import okcode.biz.trading.intf.SafetyConfigService;
import okcode.biz.trading.util.BizKeyValue;
import okcode.service.standard.intf.ConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SafetyConfigServiceImpl implements SafetyConfigService {

	@Autowired
	private ConfigService configService;
	
	@Override
	public void saveSafetyConfig(SafetyConfigDto dto) {
		Map<String, String> ownerValues = dto.toMap();
		configService.saveConfigs(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_SAFETY_CONFIG.toString(), ownerValues, 0L);
	}

	@Override
	public SafetyConfigDto findSafetyConfig() {
		Map<String, String> map = configService.findConfigValues(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_SAFETY_CONFIG.toString(), SafetyConfigDto.getKeys());
		return new SafetyConfigDto(map);
	}

}
