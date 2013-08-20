package okcode.biz.trading.site.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import okcode.biz.trading.dto.CatalogItem;
import okcode.biz.trading.enums.CatalogClickDisplay;
import okcode.biz.trading.enums.CatalogLevel;
import okcode.biz.trading.enums.CatalogNavDisplay;
import okcode.biz.trading.enums.Module;
import okcode.biz.trading.intf.CatalogService;
import okcode.biz.trading.model.Catalog;
import okcode.biz.trading.site.dao.ArticleDao;
import okcode.biz.trading.site.dao.CatalogDao;
import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	private CatalogDao catalogDao;
	@Autowired
	private ArticleDao articleDao;
	
	private CatalogLevel getSetLevel(Catalog catalog) {
		if (catalog.getPid() != null && catalog.getPid() > 0) {
			Long pid = catalog.getPid();
			Catalog pcatalog = catalogDao.findOne(pid);
			if (pcatalog.getLevel().ordinal() == CatalogLevel.FIRST.ordinal()) {
				return CatalogLevel.SECOND;
			} else if (pcatalog.getLevel().ordinal() == CatalogLevel.SECOND.ordinal()) {
				return CatalogLevel.THIRD;
			} else {
				throw new AppException(ErrorCode.ILLEGAL_PARAM, "父栏目非法！");
			}
		} else {
			return CatalogLevel.FIRST;
		}
	}

	@Override
	public Catalog saveCatalog(Catalog catalog) {
		Catalog sameAliasCatalog = findByAlias(catalog.getModule(), catalog.getAlias());
		if ( (catalog.getId() == null && sameAliasCatalog != null)
				|| (catalog.getId() != null && sameAliasCatalog != null && !sameAliasCatalog.getId().equals(catalog.getId())) )
			throw new AppException(ErrorCode.ENTITY_ALREADY_EXIST, "访问别名已被使用，请换一个！");
		
		Date now = new Date();
		Catalog entity = null;
		if (catalog.getId() == null) {
			entity = new Catalog();
			entity.setUpdateAt(now);
			entity.setCreateAt(now);
		} else {
			entity = catalogDao.findOne(catalog.getId());
			if (entity == null)
				throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "要更新的栏目没有找到！");
			entity.setUpdateAt(now);
		}
		entity.setAlias(catalog.getAlias());
		entity.setClickDisplay(catalog.getClickDisplay());
		entity.setLevel(getSetLevel(catalog));
		entity.setModule(catalog.getModule());
		entity.setNavDisplay(catalog.getNavDisplay());
		entity.setNewWindowOpen(catalog.getNewWindowOpen() != null ? catalog.getNewWindowOpen() : false);
		entity.setPid(catalog.getPid() == null ? null : (catalog.getPid() == 0 ? null : catalog.getPid()));
		entity.setRank(catalog.getRank() != null ? catalog.getRank() : 0);
		entity.setSubTitle(catalog.getSubTitle());
		entity.setTitle(catalog.getTitle());
		
		if (entity.getModule().ordinal() == Module.job.ordinal()) {
			handleSaveJob(catalog, entity);
		} else if (entity.getModule().ordinal() == Module.outlink.ordinal()) {
			handleSaveOutlink(catalog, entity);
		}
		return catalogDao.save(entity);
	}
	
	private Catalog handleSaveJob(Catalog catalog, Catalog entity) {
		entity.setClickDisplay(CatalogClickDisplay.CONTENT_LIST);
		return entity;
	}
	
	private Catalog handleSaveOutlink(Catalog catalog, Catalog entity) {
		if (entity.getAttributes() == null)
			entity.setAttributes(new HashMap<String, String>());
		entity.getAttributes().put(Catalog.ATTR_KEY_OUTLINK_URL, catalog.getOutlinkUrl());
		return entity;
	}
	
	@Override
	public Catalog deleteCatalog(Long catalogId) {
		Catalog catalog = catalogDao.findOne(catalogId);
		if (catalog == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "栏目不存在！");
		
		if (!CollectionUtils.isEmpty(findByParent(catalogId)))
			throw new AppException(ErrorCode.UN_SUPPORTED, "该栏目下存在子栏目，请先删除子栏目后再试！");
		
		if (!CollectionUtils.isEmpty(articleDao.findByCatalogIdInOrderByUpdateAtDesc(Collections.singleton(catalogId)) ))
			throw new AppException(ErrorCode.UN_SUPPORTED, "该栏目下还有内容，请先删除内容后再试！");
		
		catalogDao.delete(catalog);
		return catalog;
	}

	@Override
	public Catalog findById(Long id) {
		return catalogDao.findOne(id);
	}
	
	@Override
	public List<Catalog> findByIds(Collection<Long> ids) {
		return catalogDao.findByIdInOrderByRankAsc(ids);
	}

	@Override
	public List<Catalog> findByLevel(CatalogLevel level) {
		return catalogDao.findByLevelInOrderByRankAsc(Collections.singleton(level));
	}

	@Override
	public List<Catalog> findByParent(Long pid) {
		return catalogDao.findByPidInOrderByRankAsc(Collections.singleton(pid));
	}
	
	@Override
	public List<Catalog> findAllByParent(Long pid) {
		List<Catalog> catalogs = new ArrayList<Catalog>();
		List<Catalog> subs = catalogDao.findByPidInOrderByRankAsc(Collections.singleton(pid));
		if (!CollectionUtils.isEmpty(subs)) {
			catalogs.addAll(subs);
			for (Catalog c : subs) {
				if (c.getLevel().ordinal() == CatalogLevel.THIRD.ordinal())
					continue;
				catalogs.addAll(findAllByParent(c.getId()));
			}
		}
		return catalogs;
	}
	
	@Override
	public List<Catalog> findByModule(Module module) {
		return catalogDao.findByModuleOrderByRankAsc(module);
	}

	@Override
	public List<Catalog> findAll() {
		return catalogDao.findAllOrderByRankAsc();
	}

	@Override
	public Catalog findByAlias(Module module, String alias) {
		List<Catalog> list = catalogDao.findByModuleAndAliasOrderByRankAsc(module,alias);
		if (CollectionUtils.isEmpty(list))
			return null;
		if (list.size() > 1)
			throw new AppException(ErrorCode.SERVER_ERROR);
		return list.get(0);
	}

	@Override
	public List<CatalogItem> listCatalogItems() {
		List<Catalog> catalogs = findAll();
		
		if (CollectionUtils.isEmpty(catalogs)) 
			return new ArrayList<CatalogItem>();
		
		Map<Long, List<CatalogItem>> thirdChildrenMap = new LinkedHashMap<Long, List<CatalogItem>>();
		for (Catalog c : catalogs) {
			if (c.getLevel().ordinal() == CatalogLevel.THIRD.ordinal()) {
				if (!thirdChildrenMap.containsKey(c.getPid()))
					thirdChildrenMap.put(c.getPid(), new ArrayList<CatalogItem>());
				
				CatalogItem ct = new CatalogItem();
				ct.setCatalog(c);
				thirdChildrenMap.get(c.getPid()).add(ct);
			}
		}
		
		Map<Long, List<CatalogItem>> secondChildrenMap = new LinkedHashMap<Long, List<CatalogItem>>();
		for (Catalog c : catalogs) {
			if (c.getLevel().ordinal() == CatalogLevel.SECOND.ordinal()) {
				if (!secondChildrenMap.containsKey(c.getPid()))
					secondChildrenMap.put(c.getPid(), new ArrayList<CatalogItem>());
				
				CatalogItem ct = new CatalogItem();
				ct.setCatalog(c);
				ct.setSubCatalog(thirdChildrenMap.get(c.getId()));
				secondChildrenMap.get(c.getPid()).add(ct);
			}
		}
		
		List<CatalogItem> list = new ArrayList<CatalogItem>();
		for (Catalog c : catalogs) {
			if (c.getLevel().ordinal() == CatalogLevel.FIRST.ordinal()) {
				CatalogItem ct = new CatalogItem();
				ct.setCatalog(c);
				ct.setSubCatalog(secondChildrenMap.get(c.getId()));
				list.add(ct);
			}
		}
		
		return list;
	}

	@Override
	public List<CatalogItem> listNavCatalogItems() {
		List<CatalogItem> catalogItems = listCatalogItems();
		
		if (CollectionUtils.isEmpty(catalogItems))
			return new ArrayList<CatalogItem>();
		
		List<CatalogItem> target = new ArrayList<CatalogItem>();
		for (CatalogItem firstCatalogItem : catalogItems) {
			if (firstCatalogItem.getCatalog().getNavDisplay().ordinal() == CatalogNavDisplay.MAIN.ordinal()
					|| firstCatalogItem.getCatalog().getNavDisplay().ordinal() == CatalogNavDisplay.BOTH.ordinal()) {
				target.add(firstCatalogItem);
			}
			
			if (CollectionUtils.isEmpty(firstCatalogItem.getSubCatalog()))
				continue;
			
			for (CatalogItem secondCatalogItem : firstCatalogItem.getSubCatalog()) {
				if (secondCatalogItem.getCatalog().getNavDisplay().ordinal() == CatalogNavDisplay.MAIN.ordinal()
						|| secondCatalogItem.getCatalog().getNavDisplay().ordinal() == CatalogNavDisplay.BOTH.ordinal()) {
					target.add(secondCatalogItem);
				}
				
				if (CollectionUtils.isEmpty(secondCatalogItem.getSubCatalog()))
					continue;
				
				for (CatalogItem thirdCatalogItem : secondCatalogItem.getSubCatalog()) {
					if (thirdCatalogItem.getCatalog().getNavDisplay().ordinal() == CatalogNavDisplay.MAIN.ordinal()
							|| thirdCatalogItem.getCatalog().getNavDisplay().ordinal() == CatalogNavDisplay.BOTH.ordinal()) {
						target.add(thirdCatalogItem);
					}
				}
			}
		}
		Collections.sort(target, new Comparator<CatalogItem>() {
			@Override
			public int compare(CatalogItem o1, CatalogItem o2) {
				return new Long(o1.getCatalog().getRank() - o2.getCatalog().getRank()).intValue();
			}
		});
		return target;
	}
	
	@Override
	public List<Catalog> listBottomCatalogs() {
		List<Catalog> catalogs = findAll();
		List<Catalog> bottomCatalogs = new ArrayList<Catalog>();
		if (CollectionUtils.isEmpty(catalogs))
			return Collections.emptyList();
		for (Catalog catalog : catalogs) {
			if (catalog.getNavDisplay().ordinal() == CatalogNavDisplay.BOTTOM.ordinal()
					|| catalog.getNavDisplay().ordinal() == CatalogNavDisplay.BOTH.ordinal())
				bottomCatalogs.add(catalog);
		}
		return bottomCatalogs;
	}

	@Override
	public Catalog findNavCatalog(Catalog catalog) {
		if (catalog == null)
			return null;
		if (catalog.getNavDisplay().ordinal() == CatalogNavDisplay.MAIN.ordinal()
				|| catalog.getNavDisplay().ordinal() == CatalogNavDisplay.BOTH.ordinal())
			return catalog;
		if (catalog.getPid() == null || catalog.getPid() <= 0)
			return null;
		return findNavCatalog(catalogDao.findOne(catalog.getPid()));
	}

	@Override
	public List<Catalog> findNavBreadCatalogs(Catalog catalog) {
		if (catalog == null)
			return null;
		
		List<Catalog> catalogs = new ArrayList<Catalog>();
		//一级
		if (catalog.getPid() == null || catalog.getPid() <= 0) {
			catalogs.add(catalog);			
			return catalogs;
		}
		
		//二级
		Catalog parent2 = catalogDao.findOne(catalog.getPid());
		if (parent2.getPid() == null || parent2.getPid() <= 0) {
			catalogs.add(parent2);
			catalogs.add(catalog);			
			return catalogs;
		}
		
		//三级
		Catalog parent1 = catalogDao.findOne(parent2.getPid());
		catalogs.add(parent1);
		catalogs.add(parent2);
		catalogs.add(catalog);
		return catalogs;
	}
}
