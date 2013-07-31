//package okcode.service.standard.intf;
//
//import okcode.service.standard.enums.UserGroup;
//import okcode.service.standard.model.User;
//
//
///**
// * User业务层接口
// * 
// * @author MICHAEL
// */
//public interface UserService {
//	
//	boolean canUseUserName(String username);
//	
//	long addUser(String username, String password, UserGroup userGroup);
//	
//	User findUser(long id);
//
//	User findUser(String credential);
//	
//	void updateBaseInfo(User user);
//	
//	void updateBindEmail(Long userId, String email);
//	
//	void updateBindModile(Long userId, String mobile);
//	
//	
//	void sendResetPasswordEmail(Long userId, String userAddress);
//	
//	User findUserByPasswordUrl(String passwordUrl);
//	
//	void clearUpdatePasswordUrlStr(Long userId);
//	
//}
