package okcode.service.standard.identity.realm;

import java.util.Collections;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okcode.service.standard.intf.UserAuthService;
import okcode.service.standard.model.UserAuth;


/**
 * Shiro框架自定义Realm
 * @author Administrator
 *
 */
@Service
public class UserAuthorizingRealm extends AuthorizingRealm {
	//自动装配的dao需要在shiro.xml中显式配置
	@Autowired
	private UserAuthService authUserService;
	
	/*
	 * 授权 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		UserAuth userAuth = (UserAuth) getAvailablePrincipal(principals);
		if (userAuth != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setRoles(Collections.singleton(userAuth.getUserGroup().toString()));
			return info;
		}
		return null;
	}

	/*
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;   
        String input = token.getUsername();
    	if (StringUtils.isEmpty(input) )
            throw new AuthenticationException();
    	UserAuth ua = null;
    	if (input.contains("@")) {
    		ua = authUserService.findUserAuthByEmail(input);
    	} else {
    		ua = authUserService.findUserAuthByName(input);
    	}
        //TODO 记录用户登录日志
        return new SimpleAuthenticationInfo(ua, ua.getPassword(), getName());
	}

}
