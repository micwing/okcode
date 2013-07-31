/**
 * @Project: biz-trading
 * @File: SpecificDao.java
 * @Package okcode.biz.trading.site.dao
 * @Description:
 * @author micwing
 * @date 2013-7-25 下午5:19:52
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
package okcode.biz.trading.site.dao;

import java.util.Collection;
import java.util.List;

import okcode.biz.trading.enums.Module;
import okcode.biz.trading.model.Article;

/** 
 * @ClassName: SpecificDao 
 * @Description: 
 * @author micwing
 * @date 2013-7-25 下午5:19:52 
 */
public interface SpecificDao {

	List<Article> listArticle(Module module, Collection<Long> catalogIds, String key, int start, int size);
	
	long countArticle(Module module, Collection<Long> catalogIds, String key);
}
