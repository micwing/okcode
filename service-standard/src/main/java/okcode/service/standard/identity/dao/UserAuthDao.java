package okcode.service.standard.identity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import okcode.service.standard.model.UserAuth;

@Repository
public interface UserAuthDao extends JpaRepository<UserAuth, Long>{
	
	UserAuth findByCredentialName(String credentialName);
	
	UserAuth findByCredentialEmail(String credentialEmail);
	
	UserAuth findByCredentialMobile(String credentialMobile);
	
}
