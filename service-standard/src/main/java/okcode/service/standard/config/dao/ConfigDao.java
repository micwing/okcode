package okcode.service.standard.config.dao;

import java.util.Collection;
import java.util.List;

import okcode.service.standard.model.Config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 配置服务持久层访问接口
 * 
 * @author MICHAEL
 *
 */
@Repository
public interface ConfigDao extends JpaRepository<Config, Long> {
	
	Config findByBizIdAndOwner(Long bizId, String owner);

	List<Config> findByBizIdAndOwnerIn(Long bizId, Collection<String> owners);
	
}
