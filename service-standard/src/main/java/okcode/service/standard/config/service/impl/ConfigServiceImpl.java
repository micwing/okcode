package okcode.service.standard.config.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okcode.service.standard.biz.dao.BizDao;
import okcode.service.standard.config.dao.ConfigDao;
import okcode.service.standard.enums.Status;
import okcode.service.standard.intf.ConfigService;
import okcode.service.standard.model.Config;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;


@Service
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private ConfigDao configDao;
	
	@Autowired
	private BizDao bizDao;

	private Config save(Long bizId, String owner, String value,
			Long userId) {
		Config config = configDao.findByBizIdAndOwner(bizId, owner);
		if (config == null) {
			config = new Config();
			config.setBizId(bizId);
			config.setOwner(owner);
			config.setStatus(Status.NORMAL);
		}
		config.setValue(value);
		config.setUserId(userId);
		config.setUpdateAt(new Date());
		configDao.save(config);
		return config;
	}
	@Override
	public Config saveConfig(String bizKey, String owner, String value,
			Long userId) {
		return save(bizDao.findByBizKey(bizKey).getId(), owner, value, userId);
	}

	@Override
	public Map<String, Config> saveConfigs(String bizKey,
			Map<String, String> ownerValues, Long userId) {
		Long bizId = bizDao.findByBizKey(bizKey).getId();
		Map<String, Config> map = new HashMap<String, Config>();
		for (Map.Entry<String, String> entry : ownerValues.entrySet()) {
			Config config = save(bizId, entry.getKey(), entry.getValue(), userId);
			map.put(entry.getKey(), config);
		}
		return map;
	}

	@Override
	public Config findConfig(String bizKey, String owner) {
		return findConfigs(bizKey, Collections.singleton(owner)).get(owner);
	}

	@Override
	public Map<String, Config> findConfigs(String bizKey, Set<String> owners) {
		Long bizId = bizDao.findByBizKey(bizKey).getId();
		List<Config> configs = configDao.findByBizIdAndOwnerIn(bizId, owners);
		Map<String, Config> map = new HashMap<String, Config>();
		if (CollectionUtils.isEmpty(configs))
			return map;
		for (Config config : configs) {
			map.put(config.getOwner(), config);
		}
		return map;
	}

	@Override
	public String findConfigValue(String bizKey, String owner) {
		return findConfigValues(bizKey, Collections.singleton(owner)).get(owner);
	}

	@Override
	public Map<String, String> findConfigValues(String bizKey,
			Set<String> owners) {
		Map<String, Config> configMap = findConfigs(bizKey, owners);
		if (MapUtils.isEmpty(configMap))
			return Collections.emptyMap();
		Map<String, String> map = Maps.newHashMapWithExpectedSize(configMap.size());
		for (Map.Entry<String , Config> entry : configMap.entrySet()) {
			map.put(entry.getKey(), entry.getValue().getValue());
		}
		return map;
	}
	
	
}
