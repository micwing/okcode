//package okcode.service.standard.identity.service.impl;
//
//import java.util.Date;
//import java.util.List;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import okcode.framework.exception.AppException;
//import okcode.framework.exception.ErrorCode;
//import okcode.framework.utils.Md5Coder;
//import okcode.service.standard.enums.UserGroup;
//import okcode.service.standard.identity.dao.SpecificUserDao;
//import okcode.service.standard.identity.dao.UserDao;
//import okcode.service.standard.intf.EventService;
//import okcode.service.standard.intf.UserAuthService;
//import okcode.service.standard.intf.UserService;
//import okcode.service.standard.model.User;
//import okcode.service.standard.model.UserAuth;
//
//
///**
// * User业务实现
// */
//@Service
//public class UserServiceImpl implements UserService {
//	@Autowired
//	private UserDao userDao;
//	@Autowired
//	private SpecificUserDao specificUserDao;
//	@Autowired
//	private UserAuthService userAuthService;
//	@Autowired
//	private EventService eventService;
//	
//	@Override
//	public boolean canUseUserName(String username) {
//		return (userDao.findByUserName(username) == null);
//	}
//	
//	@Override
//	public long addUser(String username, String password, UserGroup userGroup) {
//		User e = new User();
//		e.setId(null);
//		if (!canUseUserName(username))
//			throw new AppException(ErrorCode.ENTITY_ALREADY_EXIST, "该用户名已被使用");
//		e.setNickName(username);
//		e.setUserName(username);
//		Date now = new Date();
//		e.setCreateAt(now);
//		e.setUpdateAt(now);
//		userDao.save(e);
//		userAuthService.addUserAuth(e, password, userGroup);
//		return e.getId();
//	}
//	
//	@Override
//	public User findUser(long id){
//		return userDao.findOne(id);
//	}
//
//	@Override
//	public User findUser(String credential){
//		UserAuth ua = userAuthService.findUserAuth(credential);
//		if (ua == null)
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "用户不存在");
//		return ua.getUser();
//	}
//
//	@Override
//	public void updateBaseInfo(User user)   {
//		User entity = findUser(user.getId());
//		if (entity == null)
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND, "用户不存在");
//		User temp = userDao.findByNickName(user.getNickName());
//		if (temp != null && temp.getId() != user.getId())
//			throw new AppException(ErrorCode.ENTITY_ALREADY_EXIST, "该昵称已被使用");
//		entity.setBirthday(user.getBirthday());
//		entity.setDescription(user.getDescription());
//		entity.setGender(user.getGender());
//		entity.setNickName(user.getNickName());
//		entity.setQq(user.getQq());
//		entity.setUpdateAt(new Date());
//		userDao.save(entity);
//	}
//
//	@Override
//	public void updateBindEmail(Long userId, String email) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void updateBindModile(Long userId, String mobile) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void sendResetPasswordEmail(Long userId, String userAddress) {
//		User user = userDao.findOne(userId);
//		if (user == null)
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND);
//		String passwordUrl = "";
//		try {
//			passwordUrl = Md5Coder.EncoderByMd5(new Date().getTime()+((int)(Math.random()*1000)+""));
//		} catch (Exception e) {
//			throw new AppException(ErrorCode.SERVER_ERROR);
//		}
//		user.getAttributes().put(User.ATTR_PASSWORD_URL, passwordUrl);
//		eventService.sendResetPasswordEmailEvent(userId,userAddress, passwordUrl);
//	}
//
//	@Override
//	public void clearUpdatePasswordUrlStr(Long userId) {
//		User user = userDao.findOne(userId);
//		if (user == null)
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND);
//		user.getAttributes().remove(User.ATTR_PASSWORD_URL);
//	}
//
//	@Override
//	public User findUserByPasswordUrl(String passwordUrl) {
//		List<Long> userIds = specificUserDao.findUserIdByAttr(User.ATTR_PASSWORD_URL, passwordUrl);
//		if (CollectionUtils.isEmpty(userIds))
//			throw new AppException(ErrorCode.ENTITY_NOT_FOUND);
//		if (userIds.size() > 1)
//			throw new AppException(ErrorCode.SERVER_ERROR);
//		
//		return userDao.findOne(userIds.get(0));
//	}
//
////	public static void main(String[] args) throws Exception {
////		System.out.println(Md5Coder.EncoderByMd5("123456"));
////	}
//}
