package okcode.service.standard.identity.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import okcode.service.standard.identity.dao.SpecificUserDao;


/**
 * User数据持久层接口Hibernate实现类
 * 
 * @author MICHAEL WING
 */
@Repository
public class SpecificUserDaoImpl implements SpecificUserDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Long> findUserIdByAttr(String key, String val) {
		Query query = em.createNativeQuery("select user_id from m_identity_user_attr where attr_key = :k and attr_value = :v"
				);
		query.setParameter("k", key);
		query.setParameter("v", val);
		List<Object> list = query.getResultList();
		if (CollectionUtils.isEmpty(list))
			return Collections.emptyList();
		List<Long> lst = new ArrayList<Long>();
		for (Object obj : list) {
			lst.add(new Long(obj.toString()));
		}
		return lst;
	}
}
