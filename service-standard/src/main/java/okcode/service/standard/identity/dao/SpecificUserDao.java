package okcode.service.standard.identity.dao;

import java.util.List;


public interface SpecificUserDao {
	
	List<Long> findUserIdByAttr(String key, String val);
}
