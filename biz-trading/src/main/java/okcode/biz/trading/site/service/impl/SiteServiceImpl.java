//package okcode.biz.trading.site.service.impl;
//
//import java.util.Collections;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.collections.MapUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import okcode.biz.trading.intf.SiteService;
//import okcode.biz.trading.intf.TemplateService;
//import okcode.biz.trading.model.Site;
//import okcode.biz.trading.model.Template;
//import okcode.biz.trading.site.dao.SiteDao;
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.service.standard.enums.Status;
//
//@Service
//public class SiteServiceImpl implements SiteService {
//	@Autowired
//	private SiteDao siteDao;
//	@Autowired
//	private TemplateService templateSerivce;
//	
//	@Override
//	public Site findById(Long id) {
//		return siteDao.findOne(id);
//	}
//
//	@Override
//	public List<Site> findByUser(Long userId) {
//		return siteDao.findByUser(userId);
//	}
//
//	@Override
//	public Site create(Site site) {
//		//TODO check site
//		site.setStatus(Status.NORMAL);
//		if (site.getTemplateId() == null)
//			throw new AppException(ErrorCode.ILLEGAL_PARAM, "模板不能为空");
//		Template template = templateSerivce.findById(site.getTemplateId());
//		if (template == null)
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, site.getTemplateId()+"模板未找到");
//		site.setTemplate(template);
//		Date now = new Date();
//		site.setCreateAt(now);
//		site.setUpdateAt(now);
//		siteDao.save(site);
//		return site;
//	}
//	
//	@Override
//	public Site updateBaseInfo(Site site,Long userId) {
//		if (site.getId() == null)
//			throw new AppException(ErrorCode.MISS_PARAM, "id不能为空");
//		
//		if (!checkUserOwn(Collections.singleton(site.getId()), userId))
//			throw new AppException(ErrorCode.NO_PERMISSON, "您没有权限操作");
//		Site entity = siteDao.findOne(site.getId());
//		
//		Site temp = siteDao.findByAlias(site.getAlias());
//		if (temp != null && temp.getId().longValue() != site.getId().longValue())
//			throw new AppException(ErrorCode.ENTITY_ALREADY_EXIST, "别名已存在");
//		entity.setAlias(site.getAlias());
//		entity.setDescription(site.getDescription());
//		entity.setName(site.getName());
//		entity.setUpdateAt(new Date());
//		
//		siteDao.save(entity);
//		return entity;
//	}
//	
//	@Override
//	public Site updateTemplate(Site site, Long userId) {
//		if (site.getId() == null)
//			throw new AppException(ErrorCode.MISS_PARAM, "id不能为空");
//		
//		if (!checkUserOwn(Collections.singleton(site.getId()), userId))
//			throw new AppException(ErrorCode.NO_PERMISSON, "您没有权限操作");
//		Site entity = siteDao.findOne(site.getId());
//		
//		entity.setTemplate(site.getTemplate());
//		entity.setUpdateAt(new Date());
//		
//		siteDao.save(entity);
//		return entity;
//	}
//	
//	@Override
//	public Site updateSeoInfo(Site site, Long userId) {
//		if (site.getId() == null)
//			throw new AppException(ErrorCode.MISS_PARAM, "id不能为空");
//		
//		if (!checkUserOwn(Collections.singleton(site.getId()), userId))
//			throw new AppException(ErrorCode.NO_PERMISSON, "您没有权限操作");
//		Site entity = siteDao.findOne(site.getId());
//		
//		entity.setSeoDescription(site.getSeoDescription());
//		entity.setSeoKeywords(site.getSeoKeywords());
//		entity.setSeoTitle(site.getSeoTitle());
//		
//		siteDao.save(entity);
//		return entity;
//	}
//	
//	@Override
//	public Site updateAttributes(Long siteId, Map<String, String> attributes) {
//		Site site = siteDao.findOne(siteId);
//		if (site == null)
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND);
//		if (!MapUtils.isEmpty(attributes)) {
//			for (Map.Entry<String,String> entry : attributes.entrySet()) {
//				site.getAttributes().put(entry.getKey(), entry.getValue());
//			}
//		}
//		return site;
//	}
//
//	@Override
//	public Site findByAlias(String alias) {
//		return siteDao.findByAlias(alias);
//	}
//
//	@Override
//	public void deleteByUser(Set<Long> siteIds, Long userId) {
//		if (checkUserOwn(siteIds, userId)) {
//			Date now = new Date();
//			for (Site site : siteDao.findByIds(siteIds)) {
//				site.setStatus(Status.DELETED);
//				site.setUpdateAt(now);
//				siteDao.save(site);
//			}
//		}
//	}
//	
//	@Override
//	public boolean checkUserOwn(Set<Long> siteIds, Long userId) {
//		List<Site> sites = siteDao.findByUser(userId);
//		if (CollectionUtils.isEmpty(sites))
//			return false;
//		
//		Map<Long, Site> siteMap = new HashMap<Long, Site>();
//		for (Site s : sites) {
//			siteMap.put(s.getId(), s);
//		}
//		
//		for (Long siteId : siteIds) {
//			if (!siteMap.containsKey(siteId)) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	@Override
//	public Site changeStatus(Long siteId, Status status, Long userId) {
//		if (siteId == null)
//			throw new AppException(ErrorCode.MISS_PARAM, "id不能为空");
//		
//		if (!checkUserOwn(Collections.singleton(siteId), userId))
//			throw new AppException(ErrorCode.NO_PERMISSON, "您没有权限操作");
//		Site entity = siteDao.findOne(siteId);
//		
//		entity.setStatus(status);
//		entity.setUpdateAt(new Date());
//		
//		siteDao.save(entity);
//		return entity;
//	}
//	
//	@Override
//	public Site savePausedNotice(Long siteId, String notice, Long userId) {
//		if (siteId == null)
//			throw new AppException(ErrorCode.MISS_PARAM, "id不能为空");
//		
//		if (!checkUserOwn(Collections.singleton(siteId), userId))
//			throw new AppException(ErrorCode.NO_PERMISSON, "您没有权限操作");
//		Site entity = siteDao.findOne(siteId);
//		
//		entity.getAttributes().put(Site.ATTR_PAUSED_NOTICE, notice);
//		entity.setUpdateAt(new Date());
//		
//		siteDao.save(entity);
//		return entity;
//	}
//
//}