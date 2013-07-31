//package okcode.service.standard.identity.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import okcode.service.standard.model.User;
//
//
//
///**
// * 用户持久层访问接口
// * 
// * @author MICHAEL
// */
//@Repository
//public interface UserDao extends JpaRepository<User, Long>{
//	@Query("from User where userName = ?1")
//	User findByUserName(String userName);
//	
//	@Query("from User where nickName = ?1")
//	User findByNickName(String nickName);
//	
//}
