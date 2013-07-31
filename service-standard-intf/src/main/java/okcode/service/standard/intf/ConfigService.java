package okcode.service.standard.intf;

import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;

import okcode.service.standard.model.Config;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ConfigService {
	
	Config saveConfig(@NotBlank String bizKey, @NotBlank String owner, @NotBlank String value, @NotNull Long userId);
	
	Map<String, Config> saveConfigs(@NotBlank String bizKey, @NotEmpty Map<String, String> ownerValues, @NotNull Long userId);
	
	
	Config findConfig(@NotBlank String bizKey, @NotBlank String owner);
	
	Map<String, Config> findConfigs(@NotBlank String bizKey, @NotEmpty Set<String> owners);
	
	
	String findConfigValue(@NotBlank String bizKey, @NotBlank String owner);
	
	Map<String, String> findConfigValues(@NotBlank String bizKey, @NotEmpty Set<String> owners);
	
}
