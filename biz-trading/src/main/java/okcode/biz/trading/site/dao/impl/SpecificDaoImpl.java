/**
 * @Project: biz-trading
 * @File: SpecificDaoImpl.java
 * @Package okcode.biz.trading.site.dao.impl
 * @Description:
 * @author micwing
 * @date 2013-7-25 下午5:20:37
 * @version V1.0
 *
 * Copyright (c) 2013 BGoal Soft Studio. All Rights Reserved.
 *
 * Copying of this document or code and giving it to others and the
 * use or communication of the contents thereof, are forbidden without
 * expressed authority. Offenders are liable to the payment of damages.
 * All rights reserved in the event of the grant of a invention patent or the
 * registration of a utility model, design or code.
 */
package okcode.biz.trading.site.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import okcode.biz.trading.enums.Module;
import okcode.biz.trading.model.Article;
import okcode.biz.trading.site.dao.SpecificDao;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

/** 
 * @ClassName: SpecificDaoImpl 
 * @Description: 
 * @author micwing
 * @date 2013-7-25 下午5:20:37 
 */
@Repository
public class SpecificDaoImpl implements SpecificDao {
	@PersistenceContext
	private EntityManager em;

	private Query articleQuery(Module module, Collection<Long> catalogIds, String key) {
		StringBuffer buf = new StringBuffer();
		buf.append("from Article where 1=1 ");
		if (module != null)
			buf.append(" and catalog.module = :module");
		if (!CollectionUtils.isEmpty(catalogIds))
			buf.append(" and catalog.id in (:catalogIds) ");
		if (!StringUtils.isEmpty(key))
			buf.append(" and (title like :key or subTitle like :key)");
		
		Query query =  em.createQuery(buf.toString(), Article.class);
		if (module != null)
			query.setParameter("module", module);
		if (!CollectionUtils.isEmpty(catalogIds))
			query.setParameter("catalogIds", catalogIds);
		if (!StringUtils.isEmpty(key))
			query.setParameter("key", key);
		return query;
	}
	
	@Override
	public List<Article> listArticle(Module module, Collection<Long> catalogIds, String key, int start, int size) {
		Query query = articleQuery(module,catalogIds, key);
		if (start >= 0 && size > 0) {			
			query.setFirstResult(start);
			query.setMaxResults(size);
		}
		return (List<Article>) query.getResultList();
	}
	
	@Override
	public long countArticle(Module module, Collection<Long> catalogIds, String key) {
		Query query = articleQuery(module,catalogIds, key);
		return query.getResultList().size();
	}
}
