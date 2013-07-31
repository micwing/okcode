//package okcode.service.standard.standard.service.impl;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.mall.api.service.standard.AreaService;
//import okcode.mall.api.service.standard.StandardConverter;
//import okcode.mall.api.service.standard.dto.AreaDto;
//import okcode.mall.biz.standard.dao.AreaDao;
//import okcode.mall.biz.standard.dao.SpecificStandardDao;
//import okcode.mall.core.constants.GlobalConstants;
//import okcode.mall.core.enums.AreaLevel;
//import okcode.mall.core.model.Area;
//
//
///**
// * 区域标准数据服务
// * 
// * @author MICHAEL
// */
//@Service
//public class AreaServiceImpl implements AreaService {
//	@Autowired
//	private AreaDao areaDao;
//	@Autowired
//	private SpecificStandardDao specificStandardDao;
//
//	@CacheEvict(allEntries = true, value = GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public long saveArea(AreaDto areaDto) throws AppException {
//		Area area = areaDao.save(StandardConverter.toArea(areaDto, this));
//		return area.getCode();
//	}
//
//	@CacheEvict(allEntries = true, value = GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public void deleteArea(List<Long> codes) throws AppException {
//		if (CollectionUtils.isEmpty(codes))
//			return;
//		Collections.sort(codes, new Comparator<Long>() {
//			@Override
//			public int compare(Long o1, Long o2) {
//				Area area1 = findArea(o1);
//				Area area2 = findArea(o2);
//				return area2.getLevel().ordinal() - area1.getLevel().ordinal();
//			}
//		});
//		//从低到高删除
//		for (int i = 0; i <codes.size(); i++) {
//			deleteArea(codes.get(i));
//		}
//	}
//
//	@CacheEvict(allEntries = true, value = GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public void deleteArea(Long code) throws AppException {
//		Area area = areaDao.findOne(code);
//		List<Area> subList = areaDao.findSubList(code);
//		if (!CollectionUtils.isEmpty(subList))
//			throw new AppException(ErrorCode.SUB_ENTITY_EXIST);
//		areaDao.delete(area);
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public Area findArea(Long areaCode) throws AppException {
//		Area area = areaDao.findOne(areaCode);
//		return area;
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public Set<Area> findArea(Set<Long> codes) throws AppException {
//		List<Area> list = areaDao.findByCodes(codes);
//		Set<Area> set = new HashSet<Area>();
//		if (CollectionUtils.isEmpty(list))
//			return set;
//
//		for (Area area : list) {
//			set.add(area);
//		}
//		return set;
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public Map<Long, Area> findAreaMap(Set<Long> codes) throws AppException {
//		List<Area> list = areaDao.findByCodes(codes);
//		Map<Long, Area> map = new HashMap<Long, Area>();
//		if (CollectionUtils.isEmpty(list))
//			return map;
//
//		for (Area area : list) {
//			map.put(area.getCode(), area);
//		}
//		return map;
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public List<Area> findArea(AreaLevel level) throws AppException {
//		List<Area> areaList = areaDao.findByLevel(level);
//		return areaList;
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public List<Area> findAreaListByParent(Long pcode) throws AppException {
//		List<Area> subList = areaDao.findSubList(pcode);
//		return subList;
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public Map<Long, Area> findAreaMapByParent(Long pcode) throws AppException {
//		List<Area> list = areaDao.findSubList(pcode);
//		Map<Long, Area> map = new HashMap<Long, Area>();
//		if (CollectionUtils.isEmpty(list))
//			return map;
//		for (Area area : list) {
//			map.put(area.getCode(), area);
//		}
//		return map;
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public Area findParentArea(Long code) throws AppException {
//		Area area = areaDao.findOne(code);
//		if (area == null)
//			return null;
//		return area.getParent();
//	}
//
//	@Override
//	public Page<Area> listArea(Pageable pageable, final AreaDto areaDto)
//			throws AppException {
//		return areaDao.findAll(new Specification<Area>() {
//			@Override
//			public Predicate toPredicate(Root<Area> root,
//					CriteriaQuery<?> query, CriteriaBuilder cb) {
//				Long code   = areaDto.getCode();
//				String name = areaDto.getName();
//				Long pcode = areaDto.getPcode();
//				AreaLevel level = areaDto.getLevel();
//				
//				Predicate predicate = cb.conjunction();
//				
//				if (code != null && code >= 0) {
//					predicate.getExpressions().add(
//							cb.equal(root.<Long> get("code"),
//									code));
//				}
//				if (StringUtils.isNotBlank(name)) {
//					name = name.trim();
//					predicate.getExpressions().add(
//							cb.like(root.<String> get("name"),
//									"%" + StringUtils.trim(name) + "%"));
//				}
//				if (level != null) {
//					predicate.getExpressions().add(
//							cb.equal(root.<AreaLevel> get("level"),
//									level));
//				}
//				if (pcode != null && pcode >= 0) {
//					Area parent = areaDao.findOne(pcode);
//					predicate.getExpressions().add(
//							cb.equal(root.<Area> get("parent"),
//									parent));
//				}
//				
//
//				return predicate;
//			}
//		}, pageable);
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public List<Area> findAll() throws AppException {
//		return areaDao.findAll();
//	}
//
//	@Cacheable(GlobalConstants.Cache.COMMON_AREA)
//	@Override
//	public List<AreaDto> getTwoLevelArea() {
//		List<Area> allList = areaDao.findAll();
//		if (CollectionUtils.isEmpty(allList)) {
//			return new ArrayList<AreaDto>();
//		}
//		Map<Long, List<Area>> parentMap = new HashMap<Long, List<Area>>();
//		for (Area catalog : allList) {
//			if (catalog.getLevel().equals(AreaLevel.PROVINCE)) {
//				if (!parentMap.containsKey(catalog.getCode())) {
//					parentMap.put(catalog.getCode(), new ArrayList<Area>());
//				}
//				continue;
//			} else if (catalog.getLevel().equals(AreaLevel.CITY)) {
//				if (parentMap.containsKey(catalog.getParent().getCode())) {
//					parentMap.get(catalog.getParent().getCode()).add(catalog);
//				} else {
//					List<Area> lst = new ArrayList<Area>();
//					lst.add(catalog);
//					parentMap.put(catalog.getParent().getCode(), lst);
//				}
//			}
//		}
//
//		List<AreaDto> list = new ArrayList<AreaDto>();
//		for (Area catalog : allList) {
//			if (!catalog.getLevel().equals(AreaLevel.PROVINCE)) {
//				continue;
//			}
//			AreaDto dto = new AreaDto();
//			dto.setCode(catalog.getCode());
//			dto.setLevel(catalog.getLevel());
//			dto.setName(catalog.getName());
//			List<AreaDto> subList = new ArrayList<AreaDto>();
//			for (Area subCatalog : parentMap.get(catalog.getCode())) {
//				AreaDto subDto = new AreaDto();
//				subDto.setCode(subCatalog.getCode());
//				subDto.setLevel(subCatalog.getLevel());
//				subDto.setName(subCatalog.getName());
//				subDto.setPcode(catalog.getCode());
//				subList.add(subDto);
//			}
//			dto.setSubList(subList);
//			list.add(dto);
//		}
//		return list;
//	}
//
//	@Override
//	public List<Area> findAreaByName(String name) throws AppException {
//		return areaDao.findByName("%"+name+"%");
//	}
//
//}
