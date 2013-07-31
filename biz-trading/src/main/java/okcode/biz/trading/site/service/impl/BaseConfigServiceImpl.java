package okcode.biz.trading.site.service.impl;

import java.util.HashMap;
import java.util.Map;

import okcode.biz.trading.dto.BaseConfigDto;
import okcode.biz.trading.intf.BaseConfigService;
import okcode.biz.trading.site.dao.SpecificDao;
import okcode.biz.trading.util.BizKeyValue;
import okcode.service.standard.intf.ConfigService;
import okcode.service.standard.model.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BaseConfigServiceImpl implements BaseConfigService {
	@Autowired
	private SpecificDao specificDao;

	@Autowired
	private ConfigService configService;
	
	@Override
	public void saveBaseConfig(BaseConfigDto dto) {
		Map<String, String> ownerValues = dto.toMap();
		configService.saveConfigs(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG.toString(), ownerValues, dto.getUserId());
	}

	@Override
	public BaseConfigDto findBaseConfig() {
		Map<String, String> map = configService.findConfigValues(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG.toString(), BaseConfigDto.getKeys());
		return new BaseConfigDto(map);
	}

}
