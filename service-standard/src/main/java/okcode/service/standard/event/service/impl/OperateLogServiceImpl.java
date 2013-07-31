package okcode.service.standard.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okcode.service.standard.event.dao.OperateLogDao;
import okcode.service.standard.intf.OperateLogService;
import okcode.service.standard.model.OperateLog;


/**
 * 事件触发服务实现类
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
	@Autowired
	private OperateLogDao operateLogDao;

	@Override
	public List<OperateLog> list(Query query, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
