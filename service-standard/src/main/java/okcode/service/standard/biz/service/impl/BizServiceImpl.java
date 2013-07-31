package okcode.service.standard.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.service.standard.biz.dao.BizDao;
import okcode.service.standard.intf.BizService;
import okcode.service.standard.model.Biz;

@Service
public class BizServiceImpl implements BizService {
	@Autowired
	private BizDao bizDao;

	@Override
	public Biz create(Biz biz) {
		biz.setId(null);
		bizDao.save(biz);
		return biz;
	}

	@Override
	public Biz update(Biz biz) {
		if (biz.getId() == null)
			throw new AppException(ErrorCode.MISS_PARAM);
		bizDao.save(biz);
		return biz;
	}

	@Override
	public void delete(Long id) {
		bizDao.delete(id);
	}

	@Override
	public List<Biz> listAll() {
		return bizDao.findAll();
	}

	@Override
	public Biz findById(Long id) {
		return bizDao.findOne(id);
	}

	@Override
	public Biz findByBizKey(String bizKey) {
		return bizDao.findByBizKey(bizKey);
	}
	
}
