package okcode.service.standard.message.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.service.standard.enums.Status;
import okcode.service.standard.intf.MessageService;
import okcode.service.standard.message.dao.MessageDao;
import okcode.service.standard.model.Message;


/**
 * 站内信服务
 */
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;

	@Override
	public void saveMessage(Long id, Long sendUserId, Long receiveUserId,
			String title, String content, Status status) throws AppException {
		
		Message e = new Message();
		if (id != null) {
			e = messageDao.findOne(id);
			if (e == null)
				throw new AppException(ErrorCode.ENTITY_NOT_FOUND, id+"消息未找到");
		}
		e.setContent(content);
		e.setRead_flag(false);
		e.setReceiverId(receiveUserId);
		e.setSenderId(sendUserId);
		if (status == Status.NORMAL) {
			e.setSendAt(new Date());
		}
		e.setStatus(status);
		e.setTitle(title);
		messageDao.save(e);
	}

	@Override
	public Message readMessage(Long messageId) throws AppException {
		Message e = messageDao.findOne(messageId);
		if (e == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, messageId+"消息未找到");
		e.setRead_flag(true);
		return e;
	}

	@Override
	public void listMessage(Long sendUserId, Long receiveUserId, Status status) {
		
	}

	@Override
	public int countMesage(Long sendUserId, Long receiveUserId, Status status,
			Boolean readFlag) {
		// TODO Auto-generated method stub
		return 8;
	}
	
}
