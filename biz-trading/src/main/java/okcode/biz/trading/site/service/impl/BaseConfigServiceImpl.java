package okcode.biz.trading.site.service.impl;

import java.util.Map;

import okcode.biz.trading.dto.BaseConfigDto;
import okcode.biz.trading.dto.EmailConfigDto;
import okcode.biz.trading.dto.RunStatusDto;
import okcode.biz.trading.intf.BaseConfigService;
import okcode.biz.trading.util.BizKeyValue;
import okcode.service.standard.intf.ConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BaseConfigServiceImpl implements BaseConfigService {

	@Autowired
	private ConfigService configService;
	
	@Override
	public void saveBaseConfig(BaseConfigDto dto) {
		Map<String, String> ownerValues = dto.toMap();
		configService.saveConfigs(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_BASE_CONFIG.toString(), ownerValues, 0L);
	}

	@Override
	public BaseConfigDto findBaseConfig() {
		Map<String, String> map = configService.findConfigValues(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_BASE_CONFIG.toString(), BaseConfigDto.getKeys());
		return new BaseConfigDto(map);
	}

	@Override
	public void saveEmailConfig(EmailConfigDto dto) {
		Map<String, String> ownerValues = dto.toMap();
		configService.saveConfigs(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_EMAIL_CONFIG.toString(), ownerValues, 0L);
	}

	@Override
	public EmailConfigDto findEmailConfig() {
		Map<String, String> map = configService.findConfigValues(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_EMAIL_CONFIG.toString(), EmailConfigDto.getKeys());
		return new EmailConfigDto(map);
	}

	@Override
	public void saveRunStatus(RunStatusDto dto) {
		Map<String, String> ownerValues = dto.toMap();
		configService.saveConfigs(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_RUN_STATUS.toString(), ownerValues, 0L);
	}

	@Override
	public RunStatusDto findRunStatus() {
		Map<String, String> map = configService.findConfigValues(BizKeyValue.CONFIG_SERVICE_SYS_CONFIG_RUN_STATUS.toString(), RunStatusDto.getKeys());
		return new RunStatusDto(map);
	}

}
