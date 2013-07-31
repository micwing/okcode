package okcode.service.standard.count.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okcode.service.standard.biz.dao.BizDao;
import okcode.service.standard.count.dao.impl.CountDao;
import okcode.service.standard.enums.Status;
import okcode.service.standard.intf.CountService;
import okcode.service.standard.model.Count;
import okcode.service.standard.util.StandardConstants;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountServiceImpl implements CountService {
	@Autowired
	private CountDao countDao;
	
	@Autowired
	private BizDao bizDao;
	
	@Override
	public void increase(String bizKey, String owner) {
		long step = 1L;
		List<Count> counts = countDao.findByBizOwnerAndStatusInOrderByUpdateAtDesc(bizKey, Collections.singleton(owner), StandardConstants.ENABLE_STATUS);
		Count count = null;
		if (CollectionUtils.isEmpty(counts)) {
			count = new Count();
			count.setBiz(bizDao.findByBizKey(bizKey));
			count.setOwner(owner);
			count.setStatus(Status.NORMAL);
			count.setNum(0L);
		} else {
			count = counts.get(0);
		}
		count.setUpdateAt(new Date());
		count.setNum(count.getNum() + step);
		countDao.save(count);
	}
	
	@Override
	public void saveCount(String bizKey, String owner, Long num) {
		num = num == null ? 0L 
				: (num <= 0 ? 0 : num);
		List<Count> counts = countDao.findByBizOwnerAndStatusInOrderByUpdateAtDesc(bizKey, Collections.singleton(owner), StandardConstants.ENABLE_STATUS);
		Count count = null;
		if (CollectionUtils.isEmpty(counts)) {
			count = new Count();
			count.setBiz(bizDao.findByBizKey(bizKey));
			count.setOwner(owner);
			count.setStatus(Status.NORMAL);
		} else {
			count = counts.get(0);
		}
		count.setUpdateAt(new Date());
		count.setNum(num);
		countDao.save(count);
	}

	@Override
	public Count findCount(String bizKey, String owner) {
		List<Count> list = countDao.findByBizOwnerAndStatusInOrderByUpdateAtDesc(bizKey, Collections.singleton(owner), StandardConstants.ENABLE_STATUS);
		return CollectionUtils.isEmpty(list) ? null : list.get(0);
	}
	
	@Override
	public Map<String, Count> findCounts(String bizKey, Collection<String> owners) {
		List<Count> list = countDao.findByBizOwnerAndStatusInOrderByUpdateAtDesc(bizKey, owners, StandardConstants.ENABLE_STATUS);
		Map<String, Count> map = new HashMap<String, Count>();
		if (CollectionUtils.isEmpty(list))
			return map;
		for (Count count : list) {
			map.put(count.getOwner(), count);
		}
		return map;
	}
}
