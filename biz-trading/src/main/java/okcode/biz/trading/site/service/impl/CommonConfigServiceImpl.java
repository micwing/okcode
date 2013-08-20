package okcode.biz.trading.site.service.impl;

import java.util.Map;

import okcode.biz.trading.dto.CommonConfigDto;
import okcode.biz.trading.dto.SafetyConfigDto;
import okcode.biz.trading.intf.CommonConfigService;
import okcode.biz.trading.util.BizKeyValue;
import okcode.service.standard.intf.ConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CommonConfigServiceImpl implements CommonConfigService {

	@Autowired
	private ConfigService configService;
	
	@Override
	public void save(CommonConfigDto dto, BizKeyValue bizKeyValue) {
		Map<String, String> ownerValues = dto.toMap();
		configService.saveConfigs(bizKeyValue.toString(), ownerValues, 0L);
	}

	@Override
	public CommonConfigDto find(CommonConfigDto dto, BizKeyValue bizKeyValue) {
		Map<String, String> map = configService.findConfigValues(bizKeyValue.toString(), dto.getKeys());
		return dto.setMap(map);
	}

}
