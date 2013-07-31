package okcode.service.standard.intf;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import okcode.framework.exception.AppException;
import okcode.service.standard.enums.Status;
import okcode.service.standard.model.Message;

/**
 * 站内信消息服务接口
 */
public interface MessageService {

	void saveMessage(Long id, @NotNull @Min(1) Long sendUserId,@NotNull @Min(1) Long receiveUserId,@NotEmpty String title, String content, Status stastus) throws AppException;
	
	Message readMessage(@NotNull @Min(1) Long messageId) throws AppException;
	
	void listMessage(Long sendUserId, Long receiveUserId, Status status);
	
	int countMesage(Long sendUserId, Long receiveUserId, Status status, Boolean readFlag);
}