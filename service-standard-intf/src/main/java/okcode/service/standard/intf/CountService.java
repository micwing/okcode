package okcode.service.standard.intf;

import java.util.Collection;
import java.util.Map;

import javax.validation.constraints.NotNull;

import okcode.service.standard.model.Count;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CountService {
	
	void increase(@NotEmpty String bizKey, @NotNull String owner);
	
	void saveCount(@NotEmpty String bizKey, @NotNull String owner, Long num);
	
	Count findCount(@NotEmpty String bizKey, @NotNull String owner);
	
	Map<String, Count> findCounts(@NotEmpty String bizKey, @NotEmpty Collection<String> owners);
}
