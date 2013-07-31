package okcode.service.standard.event.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okcode.framework.result.Result;
import okcode.service.standard.event.dao.OperateLogDao;
import okcode.service.standard.intf.BizService;
import okcode.service.standard.intf.EmailService;
import okcode.service.standard.intf.EventService;
import okcode.service.standard.model.Biz;
import okcode.service.standard.model.OperateLog;


/**
 * 事件触发服务实现类
 */
@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private OperateLogDao operateLogDao;
	@Autowired
	private EmailService emailService;
	@Autowired
	private BizService bizService;
	
	@Override
	public void updatePasswordSuccessEvent(Long userId) {
//		OperateLog olog = new OperateLog();
//		olog.setBizId(bizService.);
//		olog.setCreateAt(new Date());
//		olog.setOwner(userId);
//		olog.setUserId(userId);
//		olog.setContent("修改密码成功");
//		operateLogDao.save(olog);
	}

	@Override
	public void createCatalogSuccessEvent(Long userId, Long owner, String title) {
//		OperateLog olog = new OperateLog();
//		olog.setBizId(Biz.HANDBILLS);
//		olog.setCreateAt(new Date());
//		olog.setOwner(owner);
//		olog.setUserId(userId);
//		olog.setContent("创建分类["+title+"]");
//		operateLogDao.save(olog);
	}

	@Override
	public void updateCatalogSuccessEvent(Long userId, Long owner, String title) {
//		OperateLog olog = new OperateLog();
//		olog.setBizId(Biz.HANDBILLS);
//		olog.setCreateAt(new Date());
//		olog.setOwner(owner);
//		olog.setUserId(userId);
//		olog.setContent("保存分类["+title+"]");
//		operateLogDao.save(olog);
	}

	@Override
	public void sendResetPasswordEmailEvent(Long userId, String userAddress,
			String passwordUrl) {
//		Map<String, String> rootMap = new HashMap<String, String>();
//		rootMap.put("passwordUrl", passwordUrl);
//		Result result = emailService.sendHtmlEmail(
//				userAddress, "中华小站网 帐户密码重置", "findUserPassword.ftl", rootMap);
//		OperateLog olog = new OperateLog();
//		olog.setBizId(Biz.IDENTITY);
//		olog.setCreateAt(new Date());
//		olog.setOwner(userId);
//		olog.setUserId(userId);
//		if (result.getCode() == 0) {
//			olog.setContent("向["+userAddress+"]发送重置密码邮件");
//		} else {
//			olog.setContent("向["+userAddress+"]发送重置密码邮件失败");
//		}
//		operateLogDao.save(olog);
	}
	
}
