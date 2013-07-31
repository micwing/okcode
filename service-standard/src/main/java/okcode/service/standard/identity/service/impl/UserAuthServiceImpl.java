package okcode.service.standard.identity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okcode.framework.exception.AppException;
import okcode.framework.exception.ErrorCode;
import okcode.service.standard.enums.UserGroup;
import okcode.service.standard.identity.dao.UserAuthDao;
import okcode.service.standard.intf.UserAuthService;
import okcode.service.standard.model.UserAuth;


/**
 * UserAuth业务实现
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {
	//这里添加的dao需要在shiro.xml中显式配置依赖
	@Autowired
	private UserAuthDao userAuthDao;

	@Override
	public UserAuth findUserAuthByName(String credentialName) {
		return userAuthDao.findByCredentialName(credentialName);
	}
	
	@Override
	public UserAuth findUserAuthByEmail(String credentialEmail) {
		return userAuthDao.findByCredentialEmail(credentialEmail);
	}
	
	@Override
	public boolean isExistCredentialName(String credentialName) {
		return findUserAuthByEmail(credentialName) != null;
	}

	@Override
	public UserAuth createByName(String credentialName, String password,
			UserGroup userGroup) {
		UserAuth ua = new UserAuth();
		ua.setCredentialName(credentialName);
		ua.setPassword(password);
		ua.setUserGroup(userGroup);
		return ua;
	}

	@Override
	public boolean isExistCredentialEmail(String credentialEmail) {
		return findUserAuthByEmail(credentialEmail) != null;
	}

	@Override
	public UserAuth createByEmail(String credentialEmail, String password,
			UserGroup userGroup) {
		UserAuth ua = new UserAuth();
		ua.setCredentialEmail(credentialEmail);
		ua.setPassword(password);
		ua.setUserGroup(userGroup);
		return ua;
	}

	@Override
	public void updatePasswordByEmail(String credentialEmail, String newPassword) {
		UserAuth ua = userAuthDao.findByCredentialEmail(credentialEmail);
		if (ua == null)
			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "凭证未找到");
		ua.setPassword(newPassword);
		userAuthDao.save(ua);
	}
	
}
