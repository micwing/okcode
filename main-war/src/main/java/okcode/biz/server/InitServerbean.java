/**
 * @Project: main-war
 * @File: Initbean.java
 * @Package okcode.biz.server
 * @Description:
 * @author micwing
 * @date 2013-7-25 下午3:49:57
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
package okcode.biz.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okcode.biz.trading.util.BizKeyValue;
import okcode.service.standard.intf.BizService;
import okcode.service.standard.model.Biz;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @ClassName: Initbean 
 * @Description: 
 * @author micwing
 * @date 2013-7-25 下午3:49:57 
 */
@Service
public class InitServerbean implements InitializingBean{
	@Autowired
	private BizService bizServcie;

	@Override
	public void afterPropertiesSet() throws Exception {
		List<Biz> all = bizServcie.listAll();
		Map<String, Biz> map = new HashMap<String, Biz>();
		for (Biz biz : all)
			map.put(biz.getBizKey(), biz);
		for (BizKeyValue bkv : BizKeyValue.values() ) {
			Biz biz = map.get(bkv.toString());
			if (biz == null) {
				biz = new Biz();
				biz.setBizKey(bkv.toString());
			} else {
				if (biz.getName().equals(bkv.getLabel())) {				
					continue;
				}
			}
			biz.setName(bkv.getLabel());
			bizServcie.create(biz);
		}
	}
}
